package com.example.patrick.servidor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import static java.lang.Byte.parseByte;

public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;
    final Bateria info;

    Client(String addr, int port, TextView textResponse, Bateria info) {//addr é relativo a address = endereço web.
        dstAddress = addr;
        dstPort = port;
        this.textResponse = textResponse;
        this.info = info;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            String bytesRead = null;
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            byte [] get = new byte[5];

            get[0] = (byte) 'G';
            get[1] = (byte) 'E';
            get[2] = (byte) 'T';
            get[3] = (byte) '\r';
            get[4] = (byte) '\n';

            socket.getOutputStream().write(info.getInfo().getBytes());

            //while ((bytesRead = inputStream.readLine()) != null) {
                bytesRead = inputStream.readLine();
                //socket.getOutputStream().write(get,0,"GET".length());//socket.getOutputStream().write(buffer, 0, bytesRead);
                //inputStream.read(buffer);
                //byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += bytesRead;
                //byteArrayOutputStream.toString("UTF-8");
           // }

            Log.d("GOOGLE GOOGLE says:", response);

            //response += "sem retorno\n";

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(result);
    }

}