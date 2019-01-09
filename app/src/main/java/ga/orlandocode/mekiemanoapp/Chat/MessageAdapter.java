package ga.orlandocode.mekiemanoapp.Chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import ga.orlandocode.mekiemanoapp.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.messageViewHolder> {

    ArrayList<MessageObject> messageList;

    public MessageAdapter(ArrayList<MessageObject> messageList){
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public messageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);


        messageViewHolder rcv = new messageViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull messageViewHolder holder, final int position) {

        holder.mMessage.setText(messageList.get(position).getMessage());

        holder.mSender.setText(messageList.get(position).getSenderId());


    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    class messageViewHolder extends RecyclerView.ViewHolder{
        TextView mMessage,
                 mSender;
        LinearLayout mLayout;
        messageViewHolder(View view){
            super(view);
            mLayout = view.findViewById(R.id.layout);

            mMessage = view.findViewById(R.id.message);
            mSender = view.findViewById(R.id.sender);
        }
    }

}
