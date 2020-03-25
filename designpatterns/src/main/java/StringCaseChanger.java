public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String res = "";
        for (int x = 0; x < drink.getText().length(); x++){
            if (Character.isLowerCase(drink.getText().charAt(x)))
                res += Character.toUpperCase(drink.getText().charAt(x));
            else
                res += Character.toLowerCase(drink.getText().charAt(x));
        }
        drink.setText(res);
    }
}
