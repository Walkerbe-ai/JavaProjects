package com.example.staffuimobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.staffuimobile.R;
import com.example.staffuimobile.models.Project;

import java.util.List;

public class ProjectAdapter extends ArrayAdapter<Project> {
    private LayoutInflater inflater;
    private int layout;
    private List<Project> projects;

    public ProjectAdapter(@NonNull Context context, int layout, List<Project> projects) {
        super(context, layout, projects);
        this.inflater = LayoutInflater.from(context);
        this.layout = layout;
        this.projects = projects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(layout, parent, false);

        TextView name = convertView.findViewById(R.id.projectName);
        TextView start = convertView.findViewById(R.id.startDate);
        TextView end = convertView.findViewById(R.id.endDate);

        Project project = projects.get(position);
        name.setText(project.getName());
        start.setText(project.getStartDate());
        end.setText(project.getEndDate());

        return convertView;
    }
}
