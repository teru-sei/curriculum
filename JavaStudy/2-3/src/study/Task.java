package study;


// ① TaskクラスにCalculatorクラスを継承させなさい。
	public class Task extends Calculator {
    /**
     * タスクの実行
     */
    public void doTask() {

        // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
        // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。
    	Calculator sum = new Calculator();
    	int a = 10;
    	int b = 20;
    	int c = 30;
    	
    	sum.plus(a);
    	System.out.println("plusメソッドの引数が一つの場合:" + sum.plus(a));
    	sum.plus(a, b);
    	System.out.println("plusメソッドの引数が二つの場合:" + sum.plus(a, b));
    	sum.plus(a, b, c);
    	System.out.println("plusメソッドの引数が三つの場合:" + sum.plus(a, b, c));
    }
}