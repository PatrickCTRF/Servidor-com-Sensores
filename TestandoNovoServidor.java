package com.example.patrick.servidor;

/**
 * Created by patrick on 10/3/16.
 */
/*public class TestandoNovoServidor {
        public static void main(String argv[]) throws Exception
        {
            String clientSentence = null, aux;
            String capitalizedSentence;
            ServerSocket welcomeSocket = new ServerSocket(6789);

            while(true)
            {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient =
                        new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                OutputStream outToClient = connectionSocket.getOutputStream();
                while((aux = inFromClient.readLine())!= null){
                    clientSentence += aux;
                }
                System.out.println("Received: " + clientSentence);
                capitalizedSentence = "Eu sou servidor\n";
                outToClient.write(capitalizedSentence.getBytes());
            }
        }
}





class TCPServer
{
   public static void main(String argv[]) throws Exception
      {
         String clientSentence = "PArt1", aux;
         String capitalizedSentence;
         ServerSocket welcomeSocket = new ServerSocket(6789);
         int i = 0;

         while(true)
         {
            i = 0;
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            OutputStream outToClient = connectionSocket.getOutputStream();
            while((i<3){
        aux = inFromClient.readLine();
        if(aux.equals("FIM")) System.out.println("Condicao Verdadeira");
        clientSentence += aux + "\n";
        System.out.println("\n"+ i++);
        }
        System.out.println("Received: " + clientSentence);
        capitalizedSentence = "Eu sou servidor\n";
        outToClient.write(capitalizedSentence.getBytes());
        }
        }
        }
*/