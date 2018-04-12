package com.eg.developer.reminder.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eg.developer.reminder.R;
import com.eg.developer.reminder.dto.RemindDTO;

import java.util.List;

/**
 * Created by Developer on 27.03.2018.
 */

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {

    private List<RemindDTO> data; //Данные из DTO

    public RemindListAdapter(List<RemindDTO> data) { //Конструктор для data
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false); //Указываем лайаут в который будем вставлять данные
        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        RemindDTO item = data.get(position); //Берем по позиции элемент из "Массива" с сервака
        holder.title.setText(item.getTitle()); //Проставляем заголовок
        holder.description.setText(item.getDescription()); //Проставляем описание
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder { //Отвечает за загрузку карточек напоминаний

        private CardView cardView; //Элементы, которыми будем управлять
        private TextView title; //Элементы, которыми будем управлять
        private TextView description; //Элементы, которыми будем управлять

        public RemindViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }
}
