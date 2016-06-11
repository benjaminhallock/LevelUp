package com.moosecanoes.levelup;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import com.sun.xml.internal.ws.api.Cancelable;

public class EventSellHeads extends Event implements Cancelable {

	private String[] heads; 
	
	private boolean cancelled;
	
    private static final HandlerList handlers = new HandlerList();
	
	public EventSellHeads() {
		super();	
		// TODO Auto-generated constructor stub
	}
	
	public EventSellHeads(boolean isAsync) {
		super(isAsync);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}
	
	static public HandlerList getHandlerList()
	{
		return handlers;
	}
	
	public int getHeadsAmount()
	{
		return heads.length; 
	}
	
	public String[] getHeads()
	{
		return heads;
	}
	
	  public void setCancelled(boolean cancel) {
	        cancelled = cancel;
	    }

	@Override
	public void cancel(boolean arg0)
	{
		cancelled = arg0;
	}

}
