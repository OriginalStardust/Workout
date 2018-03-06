package com.sunchang.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutId;


    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.workoutId = savedInstanceState.getLong("workoutId");
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = this.getView();
        TextView title = (TextView) view.findViewById(R.id.textTitle);
        Workout workout = Workout.workouts[(int) workoutId];
        title.setText(workout.getName());
        TextView description = (TextView) view.findViewById(R.id.textDescription);
        description.setText(workout.getDescription());
    }

    public void setWorkout(long workoutId) {
        this.workoutId = workoutId;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong("workoutId", workoutId);
    }
}
