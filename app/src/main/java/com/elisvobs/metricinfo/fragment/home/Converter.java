package com.elisvobs.metricinfo.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.elisvobs.metricinfo.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class Converter extends Fragment  {
    private static final String SQUARE = "  \u00B2";
    private static final String DEGREE = "  \u00B0";
    private Spinner spinner, spinner2, spinner3;
    private TextView unitText;
    private TextInputEditText unit;
    private Context context;
    private float num,no = 0;
    private DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);

        ConvertViewModel convertViewModel = new ViewModelProvider(this).get(ConvertViewModel.class);
        View root = inflater.inflate(R.layout.fragment_convert, container, false);
        setRetainInstance(true);

        context = root.getContext();
        spinner = root.findViewById(R.id.spinner);
        spinner2 = root.findViewById(R.id.spinner2);
        spinner3 = root.findViewById(R.id.spinner3);
        unitText = root.findViewById(R.id.unitText);
        unit = root.findViewById(R.id.unit);
        Button value = root.findViewById(R.id.value_button);
        Button reset = root.findViewById(R.id.reset_button);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(context,
                R.array.metrics, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new ConvertClickListener());

        value.setOnClickListener(view -> {
            if (!unit.getEditableText().toString().isEmpty() && !spinner.getSelectedItem().toString().isEmpty()) {
                num = Float.parseFloat(unit.getEditableText().toString());
                convertLength();
                convertMass();
                convertVolume();
                convertTemperature();
                convertArea();
                convertVelocity();
                convertEnergy();
                convertPower();
                convertPressure();
                convertData();
            } else {
                Snackbar snackbar = Snackbar.make(root.findViewById(R.id.activity_to_do),
                        R.string.con_num, Snackbar.LENGTH_LONG).setAction(R.string.act, view1 -> { });
                snackbar.show();
            }
        });

        reset.setOnClickListener(view -> {
            unit.getEditableText().clear();
            unitText.setText(R.string.conversion_result);
            spinner.setAdapter(dataAdapter);
        });

        return root;
    }

    private void convertData() {
        if (spinner.getSelectedItem().toString().equals("Data")) {

            if (spinner2.getSelectedItem().toString().equals("Bytes")) {
                if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", num + "  B"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  KB"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    no = (float) (0.000001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
//                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Kilobytes")) {
                if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    unitText.setText(String.format("%s", num + " KB"));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  B"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  GB"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Megabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    unitText.setText(String.format("%s", num + " MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  B"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  KB"));
                }  else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  GB"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Gigabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    unitText.setText(String.format("%s", num + "  "));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  B"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  KB"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Terabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    unitText.setText(String.format("%s", num + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", "Value is too big"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  KB"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  GB"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  PB"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Petabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    unitText.setText(String.format("%s", num + "  "));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  MB"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  GB"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  EB"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Exabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  GB"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  PB"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ZB"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", "Value is too small!"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Zetabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  TB"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  PB"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  EB"));
                } else if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    no = (float) (0.001 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  YB"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Yotabytes")) {
                if (spinner3.getSelectedItem().toString().equals("Yotabytes")) {
                    unitText.setText(String.format("%s", num + "  "));
                } else if (spinner3.getSelectedItem().toString().equals("Bytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilobytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Megabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Gigabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Terabytes")) {
                    unitText.setText(String.format("%s", "Value is too big!"));
                } else if (spinner3.getSelectedItem().toString().equals("Petabytes")) {
                    no = 1000000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  PB"));
                } else if (spinner3.getSelectedItem().toString().equals("Exabytes")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  EB"));
                } else if (spinner3.getSelectedItem().toString().equals("Zetabytes")) {
                    no = 1000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ZB"));
                }
            }
        }
    }

    private void convertPressure() {
        if (spinner.getSelectedItem().toString().equals("Pressure")) {

            if (spinner2.getSelectedItem().toString().equals("Atmospheres")) {
                if (spinner3.getSelectedItem().toString().equals("Atmospheres")) {
                    unitText.setText(String.format("%s", num + "  atm"));
                } else if (spinner3.getSelectedItem().toString().equals("Bars")) {
                    no = (float) (1.01325 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ba"));
                } else if (spinner3.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                    no = (float) (760.1275 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mmHg"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilopascals")) {
                    no = (float) (101.325 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kPa"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds per square inch")) {
                    no = (float) (14.69595 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  psi"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Bars")) {
                if (spinner3.getSelectedItem().toString().equals("Bars")) {
                    unitText.setText(String.format("%s", num + "  ba"));
                } else if (spinner3.getSelectedItem().toString().equals("Atmospheres")) {
                    no = (float) (0.986923 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  atm"));
                } else if (spinner3.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                    no = (float) (750.1875 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mmHg"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilopascals")) {
                    no = 100 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kPa"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds per square inch")) {
                    no = (float) (14.50377 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  psi"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                if (spinner3.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                    unitText.setText(String.format("%s", num + "  mmHg"));
                } else if (spinner3.getSelectedItem().toString().equals("Atmospheres")) {
                    no = (float) (0.00131557 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  atm"));
                } else if (spinner3.getSelectedItem().toString().equals("Bars")) {
                    no = (float) (0.001333 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ba"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilopascals")) {
                    no = (float) (0.1333 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kPa"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds per square inch")) {
                    no = (float) (0.0193335 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  psi"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Kilopascals")) {
                if (spinner3.getSelectedItem().toString().equals("Kilopascals")) {
                    unitText.setText(String.format("%s", num + "  kPa"));
                } else if (spinner3.getSelectedItem().toString().equals("Atmospheres")) {
                    no = (float) (0.00986923 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  atm"));
                } else if (spinner3.getSelectedItem().toString().equals("Bars")) {
                    no = (float) (0.01 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ba"));
                } else if (spinner3.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                    no = (float) (7.501875 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mmHg"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds per square inch")) {
                    no = (float) (0.145038 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  psi"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Pounds per square inch")) {
                if (spinner3.getSelectedItem().toString().equals("Pounds per square inch")) {
                    unitText.setText(String.format("%s", num + "  psi"));
                } else if (spinner3.getSelectedItem().toString().equals("Atmospheres")) {
                    no = (float) (0.068046 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  atm"));
                } else if (spinner3.getSelectedItem().toString().equals("Bars")) {
                    no = (float) (0.0689476 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ba"));
                } else if (spinner3.getSelectedItem().toString().equals("Millimeters of Mercury")) {
                    no = (float) (51.72361 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mmHg"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilopascals")) {
                    no = (float) (6.894757 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kPa"));
                }
            }
        }

    }

    private void convertPower() {
        if (spinner.getSelectedItem().toString().equals("Power")) {

            if (spinner2.getSelectedItem().toString().equals("Horsepower")) {
                if (spinner3.getSelectedItem().toString().equals("Horsepower")) {
                    unitText.setText(String.format("%s", num + "  hp"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilowatt")) {
                    no = (float) (0.746 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kW"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Kilowatt")) {
                if (spinner3.getSelectedItem().toString().equals("Kilowatt")) {
                    unitText.setText(String.format("%s", num + "  kW"));
                } else if (spinner3.getSelectedItem().toString().equals("Horsepower")) {
                    no = (float) (1.341 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  hp"));
                }
            }
        }

    }

    private void convertEnergy() {
        if (spinner.getSelectedItem().toString().equals("Energy")) {

            if (spinner2.getSelectedItem().toString().equals("Kilojoules")) {
                if (spinner3.getSelectedItem().toString().equals("Kilojoules")) {
                    unitText.setText(String.format("%s", num + "  kJ"));
                } else if (spinner3.getSelectedItem().toString().equals("British Thermal Unit")) {
                    no = (float) (0.948 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  BTU"));
                } else if (spinner3.getSelectedItem().toString().equals("Food Calories")) {
                    no = (float) (0.239006 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  cal"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("British Thermal Unit")) {
                if (spinner3.getSelectedItem().toString().equals("British Thermal Unit")) {
                    unitText.setText(String.format("%s", num + "  BTU"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilojoules")) {
                    no = (float) (1.055056 * num);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + "  kJ"));
                } else if (spinner3.getSelectedItem().toString().equals("Food Calories")) {
                    no = (float) (0.252164 * num);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + "  cal"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Food Calories")) {
                if (spinner3.getSelectedItem().toString().equals("Food Calories")) {
                    unitText.setText(String.format("%s", num + "  cal"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilojoules")) {
                    no = (float) (4.184 * num);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + "  kJ"));
                } else if (spinner3.getSelectedItem().toString().equals("British Thermal Unit")) {
                    no = (float) (3.965666 * num);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + "  BTU"));
                }
            }
        }

    }

    private void convertVelocity() {
        if (spinner.getSelectedItem().toString().equals("Velocity")) {

            if (spinner2.getSelectedItem().toString().equals("Kilometres per Hour")) {
                if (spinner3.getSelectedItem().toString().equals("Kilometres per Hour")) {
                    unitText.setText(String.format("%s", num + " kph"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles per Hour")) {
                    no = (float) (0.621427 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mph"));
                } else if (spinner3.getSelectedItem().toString().equals("Knots")) {
                    no = (float) (0.540003 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kn"));
                }
            }

            else if (spinner2.getSelectedItem().toString().equals("Miles per Hour")) {
                if (spinner3.getSelectedItem().toString().equals("Miles per Hour")) {
                    unitText.setText(String.format("%s", num + " mph"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres per Hour")) {
                    no = (float) (1.6092 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kph"));
                } else if (spinner3.getSelectedItem().toString().equals("Knots")) {
                    no = (float) (0.868974 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kn"));
                }
            }

            else if (spinner2.getSelectedItem().toString().equals("Knots")) {
                if (spinner3.getSelectedItem().toString().equals("Knots")) {
                    unitText.setText(String.format("%s", num + " kn"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres per Hour")) {
                    no = (float) (1.85184 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  kph"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles per Hour")) {
                    no = (float) (1.150783 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  mph"));
                }
            }
        }

    }

    private void convertArea() {
        if (spinner.getSelectedItem().toString().equals("Area")) {

            if (spinner2.getSelectedItem().toString().equals("Square Inches")) {
                if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    unitText.setText(String.format("%s", num + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    no = (float) (6.4516 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  cm" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = (float) (0.000694444 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = (float) (0.00064516 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = (float) (0.000771605 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
//                    no = (float) (0.00000000064516 * num);
                    unitText.setText(String.format("%s", " Value is too small! Please recheck if you really need it."));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
//                    no = (float) (0.000000000249098 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
//                    no = (float) (0.000000159422508 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
//                    no = (float) (0.000000064516 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Centimetres")) {
                if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    unitText.setText(String.format("%s", num + " cm" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = (float) (0.155 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = (float) (0.00107639 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
//                    no = (float) (0.0001 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
//                    no = (float) (0.000119599 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
//                    no = (float) (0.0000000001 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
//                    no = (float) (0.00000000003861 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
//                    no = (float) (0.000000024710538 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
//                    no = (float) (0.00000001 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Feet")) {
                if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    unitText.setText(String.format("%s", num + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = (float) (0.111111 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = (float) (0.092903 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    no = (float) (929.0304 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = 144 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
//                    no = (float) (0.00000009290304 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
//                    no = (float) (0.000000035870064 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
//                    no = (float) (0.0000229568 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
//                    no = (float) (0.0000092903 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Metres")) {
                if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    unitText.setText(String.format("%s", num + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = (float) (1.19599 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    no = 10000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = (float) (1550.003 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = (float) (10.76391 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
//                    no = (float) (0.000001 * num);
                    unitText.setText(String.format("%s", " Value is small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
//                    no = (float) (0.000000386102159 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
//                    no = (float) (0.000247105 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
//                    no = (float) (0.0001 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Yards")) {
                if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    unitText.setText(String.format("%s", num + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = 9 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = (float) (0.836127 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    no = (float) (8361.274 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = 1296 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
//                    no = (float) (0.00000083612736 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
//                    no = (float) (0.000000322830579 * num);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
//                    no = (float) (0.000206612 * num);
                    unitText.setText(String.format("%s", " Value is small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
//                    no = (float) (0.0000836127 * num);
                    unitText.setText(String.format("%s", " Value is small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Miles")) {
                if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
                    unitText.setText(String.format("%s", num + " mi" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
                    no = (float) (2.589988 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " km" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = 2589988 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = 27878400 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = 3097600 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
//                    no = 25899881103‬‬ * num;
                    unitText.setText(String.format("%s", " Value is too big! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
                    no = 640 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ac"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
                    no = (float) (258.9988 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ha"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Square Kilometres")) {
                if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
                    unitText.setText(String.format("%s", num + " km" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
                    no = (float) (0.386102 * num);
                    unitText.setText(String.format("%s", no + " mi" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = 10763910 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = 1000000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = 1195990 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
                    no = (float) (247.1054 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ac"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
                    no = 100 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ha"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Acres")) {
                if (spinner3.getSelectedItem().toString().equals("Acres")) {
                    unitText.setText(String.format("%s", num + " ac"));
                } else if (spinner3.getSelectedItem().toString().equals("Hectares")) {
                    no = (float) (0.404686 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ha" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = 43560 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = (float) (4046.856 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Yards")) {
                    no = 4840 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
                    no = (float) (0.00404686 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " km" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
                    no = (float) (0.0015625 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " mi" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = 6272640 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
                    no = 40468564 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm" + SQUARE));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Hectares")) {
                if (spinner3.getSelectedItem().toString().equals("Hectares")) {
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ha" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Acres")) {
                    no = Math.round((float) (2.471054 * num));
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ac" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Feet")) {
                    no = (float) (107639.1 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Metres")) {
                    no = 10000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Yard")) {
                    no = (float) (11959.9 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Kilometres")) {
                    no = (float) (0.01 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " km" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Miles")) {
                    no = (float) (0.00386102 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " mi" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Inches")) {
                    no = 15500031 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in" + SQUARE));
                } else if (spinner3.getSelectedItem().toString().equals("Square Centimetres")) {
//                    no = 100000000 * num;
                    unitText.setText(String.format("%s", " Value is too big! Are you sure you need it?"));
                }
            }

        }

    }

    private void convertTemperature() {
        if (spinner.getSelectedItem().toString().equals("Temperature")) {

            if (spinner2.getSelectedItem().toString().equals("Celsius")) {
                if (spinner3.getSelectedItem().toString().equals("Celsius")) {
                    unitText.setText(String.format("%s", num + DEGREE + "C"));
                } else if (spinner3.getSelectedItem().toString().equals("Fahrenheit")) {
                    no = (float) (1.8 * num) + 32;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + DEGREE + "F"));
                } else if (spinner3.getSelectedItem().toString().equals("Kelvin")) {
                    no = (float) (num + 273.15);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  K"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Fahrenheit")) {
                if (spinner3.getSelectedItem().toString().equals("Fahrenheit")) {
                    unitText.setText(String.format("%s", num + DEGREE + "F"));
                } else if (spinner3.getSelectedItem().toString().equals("Celsius")) {
                    no = (float) 0.5555555555555556 * (num - 32);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + DEGREE + "C"));
                } else if (spinner3.getSelectedItem().toString().equals("Kelvin")) {
                    no = (float) (((num - 32) * 0.5555555555555556) + 273.15);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  K"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Kelvin")) {
                if (spinner3.getSelectedItem().toString().equals("Kelvin")) {
                    unitText.setText(String.format("%s", num +  "  K"));
                } else if (spinner3.getSelectedItem().toString().equals("Celsius")) {
                    no = (float) (num - 273.15);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + DEGREE + "C"));
                } else if (spinner3.getSelectedItem().toString().equals("Fahrenheit")) {
                    no = (float) (((num - 273.15) * 0.5555555555555556) + 32);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + DEGREE + "F"));
                }
            }

        }

    }

    private void convertVolume() {
        if (spinner.getSelectedItem().toString().equals("Volume")) {

            if (spinner2.getSelectedItem().toString().equals("Bushel")) {
                if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    unitText.setText(String.format("%s", num + " bu"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 36.4);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  L"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = num * 36400;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 8.006681);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 64.05505);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 32.02752);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 1281.01);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 1230.83);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "  fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 76.9269);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + "  pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 38.46345);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 9.615863);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Litre")) {
                if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    unitText.setText(String.format("%s", num + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = num * 1000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.219969);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 1.759754);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.879877);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 35.195);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 33.814);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 2.113);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 1.056688);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.264172);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                }  else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.027472527);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Millilitre")) {
                if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    unitText.setText(String.format("%s", num + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.001);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
//                    no = (float) (num * 0.000219969);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 0.00175975);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
//                    no = (float) (num * 0.000879877);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 0.035195);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 0.033814);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 0.002113);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 0.001056688);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
//                    no = (float) (num * 0.000264);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
//                    no = (float) (num * 0.027472527);
                    // too small
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Gallon")) {
                if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    unitText.setText(String.format("%s", num + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 4.54609);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 4546.09);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = num * 8;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = num * 4;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = num * 160;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 153.7216);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 9.607599);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 4.8038);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 1.20095);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.124895696);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Pint")) {
                if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    unitText.setText(String.format("%s", num + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.568261);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.125);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 568.2613);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.5);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = num * 20;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 19.215);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 1.20095);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 0.5);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.150119);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.0156115716091081);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Quarts")) {
                if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    unitText.setText(String.format("%s", num  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 1.136523);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.25);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 1136.523);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = num * 2;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = num * 40;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 38.4304);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 2.4019);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 1.20095);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.300237);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.0312231480926403);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Fluid Ounces")) {
                if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    unitText.setText(String.format("%s", num + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.0284);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.00625);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 28.41306);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.025);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 0.05);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = (float) (num * 0.96076);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 0.0600475);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 0.0300237);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.00750594);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
//                    no = (float) (num * 0.0312231480926403);
                    // too small
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("US Fluid Ounces")) {
                if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    unitText.setText(String.format("%s", num + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.0295735);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.0650527);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 29.57353);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.0260211);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 1.040843);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 0.0520421);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = (float) (num * 0.0625);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 0.03125);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.0078125);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
//                    no = (float) (num * 0.0156115716091081);
                    // too small
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("US Pint")) {
                if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    unitText.setText(String.format("%s", num + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.473176);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.104084);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 473.1765);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.416337);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 16.65348);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = num * 16;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 0.832674);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = (float) (num * 0.5);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.125);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.0129993539321096);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("US Quarts")) {
                if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    unitText.setText(String.format("%s", num + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 0.946353);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Gallon")) {
                    no = (float) (num * 0.208169);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 946.3529);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 0.832674);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 33.30697);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = num * 32;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = num * 2;
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 1.665348);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    no = (float) (num * 0.25);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.0259987078642191);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("US Gallon")) {
                if (spinner3.getSelectedItem().toString().equals("US Gallon")) {
                    unitText.setText(String.format("%s", num + " gal"));
                } else if (spinner3.getSelectedItem().toString().equals("Litre")) {
                    no = (float) (num * 3.785412);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " L"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 6.661393);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Millilitre")) {
                    no = (float) (num * 3785.412);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ml"));
                } else if (spinner3.getSelectedItem().toString().equals("Quarts")) {
                    no = (float) (num * 3.330697);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Fluid Ounces")) {
                    no = (float) (num * 133.2279);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Fluid Ounces")) {
                    no = num * 128;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " fl oz"));
                } else if (spinner3.getSelectedItem().toString().equals("US Pint")) {
                    no = num * 8;
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("US Quarts")) {
                    no = num * 4;
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " qt"));
                } else if (spinner3.getSelectedItem().toString().equals("Pint")) {
                    no = (float) (num * 6.661393);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " pt"));
                } else if (spinner3.getSelectedItem().toString().equals("Bushel")) {
                    no = (float) (num * 0.1039948260494144);
                    unitText.setText(String.format("%s", decimalFormat.format(no)  + " bu"));
                }

            }
        }

    }

    private void convertMass() {
        if (spinner.getSelectedItem().toString().equals("Mass")) {

            if (spinner2.getSelectedItem().toString().equals("Kilograms")) {
                if (spinner3.getSelectedItem().toString().equals("Kilograms")){
                    unitText.setText(String.format("%s", num + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = num * 1000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = (float) (num * 35.27396);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = (float) (num * 2.204623);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
//                    no = (float) (num * 0.000984207);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
                    no = (float) (num * 0.001);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " t"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
                    no = (float) (num * 0.00110231);
                    unitText.setText(String.format("%s",decimalFormat.format(no)  + " sh. t"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Grams")) {
                if (spinner3.getSelectedItem().toString().equals("Grams")){
                    unitText.setText(String.format("%s", num + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = (float) (num * 0.001);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = (float) (num * 0.035274);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = (float) (num * 0.00220462);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
//                    no = (float) (num * 0.000000984206528);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
//                    no = (float) (num * 0.000001);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
//                    no = (float) (num * 0.00000110231);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Pounds")) {
                if (spinner3.getSelectedItem().toString().equals("Pounds")){
                    unitText.setText(String.format("%s", num + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = (float) (num * 0.453592);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = num * 16;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = (float) (num * 453.5924);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
//                    no = (float) (num * 0.000446429);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
//                    no = (float) (num * 0.000453592);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
//                    no = (float) (num * 0.0005);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Ounces")) {
                if (spinner3.getSelectedItem().toString().equals("Ounces")){
                    unitText.setText(String.format("%s", num + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = (float) (num * 0.0283495);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = (float) (num * 0.0625);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = (float) (num * 28.3495);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
//                    no = (float) (num * 0.0000279018);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
//                    no = (float) (num * 0.0000283495);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
                    no = (float) (num * 0.00003125);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Tons")) {
                if (spinner3.getSelectedItem().toString().equals("Tons")){
                    unitText.setText(String.format("%s", num + " l. t"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = (float) (num * 1016.047);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = num * 35840;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = num * 1016047;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = num * 2240;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
                    no = (float) (num * 1.016047);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " t"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
                    no = (float) (num * 1.12);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + " sh. t"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Tonnes")) {
                if (spinner3.getSelectedItem().toString().equals("Tonnes")){
                    unitText.setText(String.format("%s", num + " t"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = num * 1000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = (float) (num * 35273.96);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = num * 1000000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
                    no = (float) (num * 0.984207);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " l. t"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = (float) (num * 2204.623);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " lb"));
                } else if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
                    no = (float) (num * 1.102311);
                    unitText.setText(String.format("%s",decimalFormat.format(no) + " sh. t"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("US Short Ton")) {
                if (spinner3.getSelectedItem().toString().equals("US Short Ton")) {
                    unitText.setText(String.format("%s", num + " sh. t"));
                } else if (spinner3.getSelectedItem().toString().equals("Pounds")) {
                    no = 2000 * num;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "lb"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilograms")) {
                    no = (float) (907.1847 * num);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + "kg"));
                } else if (spinner3.getSelectedItem().toString().equals("Grams")) {
                    no = (float) (num * 907184.7);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " g"));
                } else if (spinner3.getSelectedItem().toString().equals("Ounces")) {
                    no = num * 32000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " oz"));
                } else if (spinner3.getSelectedItem().toString().equals("Tons")) {
                    no = (float) (num * 0.892857);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " l. t"));
                } else if (spinner3.getSelectedItem().toString().equals("Tonnes")) {
                    no = (float) (num * 0.907185);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " t"));
                }
            }

        }

    }

    private void convertLength() {
        if (spinner.getSelectedItem().toString().equals("Length")) {

            if (spinner2.getSelectedItem().toString().equals("Inches")) {
                if (spinner3.getSelectedItem().toString().equals("Inches")) {
                    unitText.setText(String.format("%s", num + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = (float) (num * 2.54);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = (float) (num * 0.08333);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
//                    no = (float) (num * 0.0000157828);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    no = (float) (num * 0.0277778);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = (float) (num * 0.0254);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
//                    no = (float) (num * 0.0000254);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Centimetres")) {
                if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    unitText.setText(String.format("%s", num + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Inches")) {
                    no = (float) (num * 0.393701);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = (float) (num * 0.0328084);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
//                    no = (float) (num * 0.00000621371);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    no = (float) (num * 0.0109361);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = (float) (num * 0.01);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
//                    no = (float) (num * 0.00001);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Metres")) {
                if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    unitText.setText(String.format("%s", num + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Inches")) {
                    no = (float) (num * 39.37008);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = (float) (num * 3.28084);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
//                    no = (float) (num * 0.000621371);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    no = (float) (num * 1.093613);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = num * 100;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
                    no = (float) (num * 0.001);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " km"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Miles")) {
                if (spinner3.getSelectedItem().toString().equals("Miles")) {
                    unitText.setText(String.format("%s", num + " mi"));
                } else if (spinner3.getSelectedItem().toString().equals("Inches")) {
                    no = num * 63360;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = (float) (num * 160934.4);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = num * 5280;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    no = num * 1760;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = (float) (num * 1609.344);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
                    no = (float) (num * 1.609344);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " km"));
                }


            } else if (spinner2.getSelectedItem().toString().equals("Kilometres")) {
                if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
                    unitText.setText(String.format("%s", num + " km"));
                } else if (spinner3.getSelectedItem().toString().equals("Inches")) {
                    no = (float) (num * 39370.08);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
                    no = (float) (num * 0.621371);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " mi"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = (float) (num * 3280.84);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    no = (float) (num * 1093.613);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = num * 1000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = num * 100000;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Yards")) {
                if (spinner3.getSelectedItem().toString().equals("Yards")) {
                    unitText.setText(String.format("%s", num + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Inch")) {
                    no = num * 36;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    no = num * 3;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
//                    no = (float) (num * 0.000568182);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = (float) (num * 91.44);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = (float) (num * 0.9144);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
//                    no = (float) (num * 0.00019144);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }

            } else if (spinner2.getSelectedItem().toString().equals("Feet")) {
                if (spinner3.getSelectedItem().toString().equals("Feet")) {
                    unitText.setText(String.format("%s", num + " ft"));
                } else if (spinner3.getSelectedItem().toString().equals("Inch")) {
                    no = num * 12;
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " in"));
                } else if (spinner3.getSelectedItem().toString().equals("Miles")) {
//                    no = (float) (num * 0.000189394);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                } else if (spinner3.getSelectedItem().toString().equals("Centimetres")) {
                    no = (float) (num * 30.48);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " cm"));
                } else if (spinner3.getSelectedItem().toString().equals("Metres")) {
                    no = (float) (num * 0.3048);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " m"));
                } else if (spinner3.getSelectedItem().toString().equals("Yard")) {
                    no = (float) (num * 0.03333);
                    unitText.setText(String.format("%s", decimalFormat.format(no) + " yd"));
                } else if (spinner3.getSelectedItem().toString().equals("Kilometres")) {
//                    no = (float) (num * 0.0003048);
                    unitText.setText(String.format("%s", " Value is too small! Are you sure you need it?"));
                }
            }

        }

    }

    class ConvertClickListener implements android.widget.AdapterView.OnItemSelectedListener {

        private void adapter(int p) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    p, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter.notifyDataSetChanged();
            spinner2.setAdapter(adapter);
            spinner3.setAdapter(adapter);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            parent.getItemAtPosition(position);

            if (position == 0) {
                adapter(R.array.nothing);
            } else if (position == 1) {
                adapter(R.array.length);
            } else if (position == 2) {
                adapter(R.array.mass);
            } else if (position == 3) {
                adapter(R.array.volume);
            } else if (position == 4) {
                adapter(R.array.temperature);
            } else if (position == 5) {
                adapter(R.array.area);
            } else if (position == 6) {
                adapter(R.array.velocity);
            } else if (position == 7) {
                adapter(R.array.energy);
            } else if (position == 8) {
                adapter(R.array.power);
            } else if (position == 9) {
                adapter(R.array.pressure);
            } else if (position == 10) {
                adapter(R.array.data);
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    }

}