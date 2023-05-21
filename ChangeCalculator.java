import java.util.Scanner;

public class ChangeCalculator {

    public static void main(String[] args) {
        int price, money;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите стоимость товара: ");
        price = in.nextInt();
        System.out.print("Внесено денег: ");
        money = in.nextInt();
        System.out.println("Считаю сдачу, подождите...");
        int[] coin = process(price, money);
        System.out.println("Вы получили сдачу: ");
        if(coin[0] == 0) {
            System.out.print("Произошла ошибка.");
        } else {
            if (coin[1] != 0) System.out.println("1 монету один рубль");
            if (coin[2] != 0) System.out.println(coin[2] + " монет два рубля");
            if (coin[5] != 0) System.out.println("1 монету пять рублей");
            if (coin[10] != 0) System.out.println(coin[10] + " монет десять рублей");
            if (coin[50] != 0) System.out.println("1 купюру пятьдесят рублей");
            if (coin[100] != 0) System.out.println(coin[100] + " купюр сто рублей");
            if (coin[500] != 0) System.out.println("1 купюру пятьсот рублей");
            if (coin[1000] != 0) System.out.println(coin[1000] + " купюр тысяча рублей");
            if (coin[5000] != 0) System.out.println(coin[5000] + " купюр пять тысяч рублей");
        }
    }

    public static int[] process(int price, int money) {
        int two, five, ten, fifty, onehundred, fivehundred, onethousand;
        int change = money - price;
        int[] coin = new int[5001];
        coin[0] = 1;
        two = change % 5;
        coin[2] = two != 0 ? two != 2 ? 2 : 1 : 0;
        change -= two;
        coin[1] = two == 3 ? 1 : 0;
        if(change >= 5) {
            five = change % 10;
            five = five == change ? change : five;
            coin[5] = five != 0 ? 1 : 0;
            change -= five;
        }
        if(change >= 10) {
            ten = change % 50;
            ten = ten == change ? change : ten;
            coin[10] = ten != 0 ? ten / 10 : 0;
            change -= ten;
        }
        if(change >= 50) {
            fifty = change % 100;
            fifty = fifty == change ? change : fifty;
            coin[50] = fifty != 0 ? 1 : 0;
            change -= fifty;
        }
        if(change >= 100) {
            onehundred = change % 500;
            onehundred = onehundred == change ? change : onehundred;
            coin[100] = onehundred != 0 ? onehundred / 100 : 0;
            change -= onehundred;
        }
        if(change >= 500) {
            fivehundred = change % 1000;
            fivehundred = fivehundred == change ? change : fivehundred;
            coin[500] = fivehundred != 0 ? 1 : 0;
            change -= fivehundred;
        }
        if(change >= 1000) {
            onethousand = change % 5000;
            onethousand = onethousand == change ? change : onethousand;
            coin[1000] = onethousand != 0 ? onethousand / 1000 : 0;
            change -= onethousand;
        }
        if(change >= 5000) {
            coin[5000] = change / 5000;
            change = 0;
        }
        if(change != 0) {
            return new int[]{0};
        }
        return coin;
    }
}