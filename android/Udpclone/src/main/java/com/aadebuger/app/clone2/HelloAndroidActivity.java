package com.aadebuger.app.clone2;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.aadebuger.app.clone2.*;

public class HelloAndroidActivity extends Activity implements OnTouchListener
{

	DatagramSocket ds;
	int serialid =1;
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  this.getF.getRootView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        View v = this.findViewById(R.id.my_relative_layout_id);
     
        v.setOnTouchListener(this);    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(com.aadebuger.app.clone2.R.menu.main, menu);
	ds = openSocket(10001);
	return true;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {   

    	System.out.println("event="+event);
    
    	if ( event.getAction()==MotionEvent.ACTION_UP)
    	{
    	String message =String.format("touchend,%.2f,%.2f,%d",event.getX(0)*960/800,event.getY(0),serialid);
    	
    	sendBackgroududp(message);
    	this.serialid=this.serialid+1;
    	}
    	if ( event.getAction()==MotionEvent.ACTION_MOVE)
    	{
    	String message =String.format("touchmoved,%.2f,%.2f,%d",event.getX(0)*960/800,event.getY(0),serialid);
    	
    	sendBackgroududp(message);
    	}	
    	if ( event.getAction()==MotionEvent.ACTION_DOWN)
    	{
    	String message =String.format("touchbegin,%.2f,%.2f,%d",event.getX(0)*960/800,event.getY(0),serialid);
    	
    	sendBackgroududp(message);
    	}	
    	  return true;   
        } 


    
    public void sendBackgroududp(String message)
    {
    	final String message1 = message;
    	Thread thread=new Thread(new Runnable()  
        {  
            @Override  
            public void run()  
            {  
            	
            	DatagramSocket ds1 = openSocket(10001);
            	
            	sendPacket(ds1,10001,"172.16.1.194",message1);
          //  	ds1.close();
            }  
        });  
        thread.start(); 
    }

    public void sendUdp(byte [] outData)
    {
    	int senderPort = 10001;
    	
   // 	   DatagramPacket out = new DatagramPacket(outData,outData.length, senderIP,senderPort);
   //        socket.send(out);
    }
    DatagramSocket openSocket(int port) {
		try	{
			return new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}
    void sendPacket(DatagramSocket socket, int port,String host,String message) {
		try	{
			InetAddress address = InetAddress.getByName(host);
			
			DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, port);
			socket.send(packet);
			Log.d("AndroidUDP", "Sent: " + packet);
			
		
		}	catch (UnknownHostException e) {
			e.printStackTrace();
		}	catch (SocketException e) {
			e.printStackTrace();
		}	catch (IOException e) {
			e.printStackTrace();
		}	finally {
			socket.close();
		}
	}
}

