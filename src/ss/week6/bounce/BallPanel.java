package ss.week6.bounce;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * BallPanel a special JPanel for drawing balls on.
 * Used with TimedBouncer.
 * @version 2005.02.22
 */
public class BallPanel extends JPanel implements ActionListener {
	private List<Ball> balls;

	public BallPanel() {
		this.balls = new java.util.ArrayList<>();
		Timer time = new Timer(5,this);
		time.start();
	}

	public class AnimateThread implements Runnable {
		public void run() {
			animate();
		}
	}

	public void animate() {
		try {
			while (true) {
				Thread.sleep(5);
				moveBalls();
				repaint();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/** Add a new ball to the ball list and start the timer if not yet running. */
	public synchronized void addNewBall() {
		this.balls.add(new Ball(this));
	}

	/**
	 * Move all balls 
	 * BEWARE: collision effects are not respecting Snellius' law. 
	 */
	public synchronized void moveBalls() {
		for (Ball b : this.balls) {
			b.move();
		}

		// collision detection
		ListIterator<Ball> ix = this.balls.listIterator();
		while (ix.hasNext()) {
			Ball b = ix.next();
			ListIterator<Ball> jx = this.balls.listIterator(ix.nextIndex());
			while (jx.hasNext()) {
				Ball other = jx.next();
				b.collide(other);
			}
		}
	}

	/**
	 * Overrides paintComponent in JPanel.
	 * Is called if repaint is called.
	 * Paints all elements of balls.
	 */
	@Override
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Ball b : this.balls) {
			b.draw(g);
		}
	}

	/**
	 * pplements the method from the interface ActionListener
	 * draw and move balls
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		moveBalls();
		repaint();
	}




}
