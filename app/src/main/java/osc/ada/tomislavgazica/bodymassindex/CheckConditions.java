package osc.ada.tomislavgazica.bodymassindex;

import android.view.View;
import android.widget.Toast;

public class CheckConditions {

    public static boolean conditionsMet(double height, double weight, View view){

        if (height == 0 || weight== 0){
            Toast.makeText(view.getContext(), "Can't enter 0", Toast.LENGTH_SHORT).show();
            return false;
        }else if (height > 250){
            Toast.makeText(view.getContext(), "Enter height less than 250cm", Toast.LENGTH_SHORT).show();
            return false;
        }else if (weight > 350){
            Toast.makeText(view.getContext(), "Enter weight less than 350kg", Toast.LENGTH_SHORT).show();
            return false;
        }else if(height < 100){
            Toast.makeText(view.getContext(), "Enter height more than 100cm", Toast.LENGTH_SHORT).show();
            return false;
        }else if (weight < 30){
            Toast.makeText(view.getContext(), "Enter weight more than 30kg.", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

}
