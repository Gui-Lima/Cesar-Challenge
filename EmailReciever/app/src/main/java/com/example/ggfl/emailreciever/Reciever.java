package com.example.ggfl.emailreciever;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Reciever extends Service {
    /*
        Sinceramente não entendi muito bem essa questão, se é para receber a thread, se é pra o serviço ficar rodando pra sempre a partir de uma chamada própria
        ou se outro app teria que iniciar o serviço com uma intent cada vez que quisesse a limpeza.
     */

    /*
        Fiz desse jeito então, a interface Messenger já lida com chamadas assíncronas criando uma fila exatamente como pede a questão, então não me preocupei com isso.
     */

    static final int MGS_CLEAN_THREAD = 1;
    Messenger myMessenger;

    @Override
    public IBinder onBind(Intent intent) {
        myMessenger = new Messenger(new IncomingHandler(this));
        return myMessenger.getBinder();
    }

    static class IncomingHandler extends Handler {
        private Context applicationContext;

        IncomingHandler(Context context) {
            applicationContext = context.getApplicationContext();
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MGS_CLEAN_THREAD:
                    if(msg.obj instanceof Email) removeDups((Email) msg.obj);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

        private void removeDups(Email threadHead){
            Map<Email, Integer> dictonary = new HashMap<>();

            if(threadHead == null) return;

            Email next = threadHead.reply;
            Email previous = threadHead;
            dictonary.put(threadHead, 0);

            while(next != null){

                if(dictonary.containsKey(next)){
                    previous.reply = next.reply;
                }
                else{
                    dictonary.put(next, 0);
                    previous = previous.reply;
                }
                next = next.reply;
            }
        }
    }

}
