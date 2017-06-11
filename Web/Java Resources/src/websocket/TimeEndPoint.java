package websocket;

import java.util.Date;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/time")
public class TimeEndPoint {
	Thread childThread;
	@OnOpen
	public void openConnection(final Session session) {
		System.out.println("Opened connection for TimeEndPoint");
		childThread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						//Thread.sleep(5000);
						session.getBasicRemote().sendText(new Date().toString());
					}
					catch(Exception ex) {
						
					}
				}
			}
		});
		childThread.start();
	}

}
