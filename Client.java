package com.example.patrick.servidor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    Client(String addr, int port, TextView textResponse) {//addr é relativo a address = endereço web.
        dstAddress = addr;
        dstPort = port;
        this.textResponse = textResponse;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead = 0;
            InputStream inputStream = socket.getInputStream();

            byte [] get = new byte[3];

            get[0] = (byte) 'G';
            get[1] = (byte) 'E';
            get[2] = (byte) 'T';

            socket.getOutputStream().write(get,0,"GET".length());

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                socket.getOutputStream().write(get,0,"GET".length());//socket.getOutputStream().write(buffer, 0, bytesRead);
                inputStream.read(buffer);
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
            }

            Log.d("GOOGLE GOOGLE says:", response);

            response += "sem retorno\n";

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