
# Rapport

Skapade layouten för activity_main med en textview med en hälsningstext, en text-edit för att skriva in text 
och en knapp för att kunna skicka vidare texten till activity_main2 (se img.png). I activity_main2 placerades en text-view
där texten ska hamna samt en text-view där det står att det är "Submitted" (se img_1.png).

För att få knappen att skicka vidare det som står i fältet för text-edit så gjordes en klass för "Button"
i MainActivity.java som kopplades till en variabel som heter "submitButton". Det skapades också en klass 
för EditText som också kopplades till en variabel som heter textField.
Variabeln submitButton kopplades till en setOnclickListener som i sin tur triggar funktionen onClick att 
skicka det som står i text-field till MainActivity2 som en sträng som döpts till "name". 
```
Button submitButton;
EditText textField;
...
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.buttonSubmit);
        textField = findViewById(R.id.editTextTextPersonName);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", textField.getText().toString()); // Optional
                startActivity(intent);
            }
        });
```
Då en sträng skickas från MainActivty så behöver den tas emot som en String. Därför användes klassen String
och kopplades till en variabel med namnet "name". Den sträng som skickas från MainActivity tas emot med 
extras.getString och läggs över till den nya variablen, som döpts till "name". TextView-elementet från 
activity_main2 har kopplats till variabeln textOutput och använder den inbyggda funktionen "setText()"
för att presentera texten på MainActivity2. 

```
    TextView textOutput;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textOutput = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }
        textOutput.setText(name);
    }
```

![img.png](img.png)
![img_1.png](img_1.png)
