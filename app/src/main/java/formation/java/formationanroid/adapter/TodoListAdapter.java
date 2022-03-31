package formation.java.formationanroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import formation.java.formationanroid.R;
import formation.java.formationanroid.entity.ToDo;

public class TodoListAdapter extends ListAdapter<ToDo, TodoViewHolder> {


    public TodoListAdapter(@NonNull DiffUtil.ItemCallback<ToDo> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TodoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        ToDo toDo = getItem(position);
        holder.bind(toDo.getTitle());
    }

    public static class ToDoDiff extends DiffUtil.ItemCallback<ToDo> {

        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}

class TodoViewHolder extends RecyclerView.ViewHolder {
    private final TextView todoItemTextView;
    private TodoViewHolder(@NonNull View itemView) {
        super(itemView);
        todoItemTextView = itemView.findViewById(R.id.textViewRecyler);
    }

    public void bind(String text) {
        todoItemTextView.setText(text);
    }
    public static TodoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return  new TodoViewHolder(view);
    }

}