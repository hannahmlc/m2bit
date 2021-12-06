package ss.week3.hotel;

public class Safe {
    protected boolean opened; //opening of tyhe safe
    protected boolean activated; // activation of the safe

    public Safe(){
        activated = false;
        opened = false;
    }

    //activates the safe
    public void activate(){
        activated = true;
    }

    // closes and deactivates safe
    public void deactivate(){
        activated = false;
        opened = false;
    }

    //  opens the safe if it is actived
    public void open(){
        if(activated) opened = true;
    }

    // closes the safe (but does not change its active/inactive status).
    public void close(){
        opened = false;
    }

    /**
     * @return true if the safe is active, false otherwise;
     */
    public boolean isActive(){
        return this.activated;
    }

    /**
     * @return true if the safe is open, false otherwise
     */
    public boolean isOpen(){
        return this.opened;

    }
}
