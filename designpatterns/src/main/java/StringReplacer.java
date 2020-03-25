public class StringReplacer implements StringTransformer {
    private char c1,c2;

    public StringReplacer(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void execute(StringDrink drink) {
        String res = "";
        for (int x = 0; x < drink.getText().length(); x++){
            if (drink.getText().charAt(x) == c1)
                res += c2;
            else
                res += drink.getText().charAt(x);
        }
        drink.setText(res);
    }
}
