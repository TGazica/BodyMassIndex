package osc.ada.tomislavgazica.bodymassindex;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edittext_height) EditText enterHeight;
    @BindView(R.id.edittext_weight) EditText enterWeight;
    @BindView(R.id.imageview_bodyImage) ImageView bodyImage;
    @BindView(R.id.textview_bodyMassIndex) TextView bodyMassIndex;
    @BindView(R.id.textview_status) TextView bodyStatus;
    @BindView(R.id.textview_bodyMassIndex_description) TextView bodyMassIndexDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_calculate)
    public void calculate(View view){
        Double height = Double.parseDouble(enterHeight.getText().toString());
        Double weight = Double.parseDouble(enterWeight.getText().toString());
        Double bmi;

        if(CheckConditions.conditionsMet(height,weight,view)){
            bmi = weight / ((height/100)*(height/100));
            bodyMassIndex.setText(bmi.toString());

            if(bmi<18.5){
                bodyImage.setImageResource(R.drawable.under_weight);
                bodyStatus.setText(R.string.underweight);
                bodyMassIndexDescription.setText(R.string.underweightDescription);
            }
            if(bmi>=18.5 && bmi <23){
                bodyImage.setImageResource(R.drawable.healthy);
                bodyStatus.setText(R.string.healthy);
                bodyMassIndexDescription.setText(R.string.healthy);
            }
            if(bmi>=23 && bmi <27.5){
                bodyImage.setImageResource(R.drawable.over_weight);
                bodyStatus.setText(R.string.overweight);
                bodyMassIndexDescription.setText(R.string.overweightDescription);
            }
            if(bmi>=27.5){
                bodyImage.setImageResource(R.drawable.obese);
                bodyStatus.setText(R.string.obese);
                bodyMassIndexDescription.setText(R.string.obeseDescription);
            }
        }

    }

}
