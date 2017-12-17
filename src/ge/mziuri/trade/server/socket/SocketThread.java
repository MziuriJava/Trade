package ge.mziuri.trade.server.socket;

import ge.mziuri.trade.server.dao.ItemDAO;
import ge.mziuri.trade.server.dao.ItemDAOimpl;
import ge.mziuri.trade.model.command.Command;
import ge.mziuri.trade.model.command.CommandResult;
import ge.mziuri.trade.model.exception.TSPException;
import ge.mziuri.trade.model.item.Item;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketThread implements Runnable{
    
    private final ItemDAO itemDAO = new ItemDAOimpl();

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Command command = (Command)in.readObject();
            switch (command) {
                case ADD_ITEM:
                    Item item = (Item)in.readObject();
                    try {
                        itemDAO.addItem(item);
                        out.writeObject(CommandResult.SUCCESSFUL);
                    } catch (TSPException ex) {
                        out.writeObject(CommandResult.FAILED);
                        ex.printStackTrace();
                    }
                    break;
                case DELETE_ITEM:
           }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }     
    }

}
