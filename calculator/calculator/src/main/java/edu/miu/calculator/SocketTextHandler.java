package edu.miu.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	@Autowired
	private OperationRepository operationRepository;
	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		System.out.println("Add Operation using webSocket message"+ message);
		for (WebSocketSession theSession : sessions){
			if (theSession.isOpen()){
				String[] msg=  message.toString().split(" + ");
				Operation operation=new Operation(Integer.parseInt(msg[0]),Integer.parseInt(msg[1]));
				operation.setResult(Integer.parseInt(msg[0]) + Integer.parseInt(msg[1]));
				operationRepository.save(operation).block();
				theSession.sendMessage(new TextMessage(message.getPayload()));
			}

		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("Connected");
		sessions.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
		System.out.println("Closed");
	}

}