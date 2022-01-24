package ss.week7.hotel.client;

import static ss.week7.hotel.protocol.ProtocolMessages.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import ss.week7.hotel.exceptions.ExitProgram;
import ss.week7.hotel.exceptions.ServerUnavailableException;

public class HotelClientTUI implements HotelClientView {

    private static final String helpMessage = "Commands:" +
        "\ni name ............... check in guest with name" +
        "\no name ............... check out guest with name" +
        "\nr name ............... request room of guest" +
        "\na name password .. activate safe, password required for PricedSafe " +
        "\nb name nights..... print bill for guest (name) and number of nights" +
        "\nh .................... help (this menu)" +
        "\np .................... print state" +
        "\nx .................... exit";

    HotelClient hotelClient;

    public HotelClientTUI(HotelClient client) {
        this.hotelClient = client;
    }

    @Override
    public void start() throws ServerUnavailableException {
        try {
            String answer = getString("Write your command : ");
            handleUserInput(answer);
        } catch (ExitProgram exitProgram) {
            hotelClient.sendExit();
        }
    }

    @Override
    public void handleUserInput(String input) throws ExitProgram, ServerUnavailableException {
        String[] splitText = input.split(" ", 3);
        char command = splitText[0].charAt(0);
        String parameter = null;
        String parameter2 = null;

        if (splitText.length >= 2) {
            parameter = splitText[1];
        }
        if (splitText.length == 3) {
            parameter2 = splitText[2];
        }

        switch (command) {
            case IN:
                if (parameter == null) {
                    showMessage("Incorrect parameter");
                } else {
                    hotelClient.doIn(parameter);
                }
                start();
                break;
            case OUT:
                if (parameter == null) {
                    showMessage("Incorrect parameter");
                } else {
                    hotelClient.doOut(parameter);
                }
                start();
                break;
            case ROOM:
                if (parameter == null) {
                    showMessage("Incorrect parameter");
                } else {
                    hotelClient.doRoom(parameter);
                }
                start();
                break;
            case ACT:
                if (parameter == null || parameter2 == null) {
                    showMessage("Incorrect parameters");
                } else {
                    hotelClient.doAct(parameter,parameter2);
                }
                start();
                break;
            case BILL:
                if (parameter == null || parameter2 == null) {
                    showMessage("Incorrect parameters");
                } else {
                    hotelClient.doBill(parameter,parameter2);
                }
                start();
                break;
            case PRINT:
                hotelClient.doPrint();
                start();
                break;
            case HELP:
                printHelpMenu();
                start();
                break;
            case EXIT:
                showMessage("Shutdown");
                hotelClient.sendExit();
                break;
            default:
                showMessage("Unknown command");
                start();
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public InetAddress getIp() {
        boolean isValid = false;
        InetAddress checkedIP = null;
        while (!isValid) {
            showMessage("Please a provide a valid Ip : ");
            String ip = new Scanner(System.in).nextLine();
            try {
                checkedIP = InetAddress.getByName(ip);
                isValid = true;
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return checkedIP;
    }

    @Override
    public String getString(String question) {
        showMessage(question);
        return new Scanner(System.in).nextLine();
    }

    @Override
    public int getInt(String question) {
        showMessage(question);
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    @Override
    public boolean getBoolean(String question) {
        showMessage(question);
        return Boolean.parseBoolean(new Scanner(System.in).nextLine());
    }

    @Override
    public void printHelpMenu() {
        showMessage(helpMessage);
    }
}