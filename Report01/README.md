# sparta Report01 과제

### 문제
```
//2-4. 다음 중 변수를 잘못 초기화 한 것은?
byte b = 256;
char c = '';
char answer = 'no';
float f = 3.14
double d = 1.4e3f;


//2-7. 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, '오류' 라고 적으세요.
System.out.println("1" + "2");
System.out.println(true+"");
System.out.println('A' + 'B');
System.out.println('1' + 2);
System.out.println('1' + '2');
System.out.println('J' +"ava");
System.out.println(true + null);



//2-8. 아래는 변수 x, y, z의 값을 서로 바꾸는 예제이다. 결과와 같이 출력되도록 코드를 넣으세요.
public class Exercise2_8{
    public static void main(String[] args){
       int x = 1;
       int y = 2;
       int z = 3;
       /*
          알맞은 코드를 넣어 완성하세요.
       */
       System.out.println("x="+x);
       System.out.println("y="+y);
       System.out.println("z="+z);
    }
}
//예상 결과 : x=2, y=3, z=1
```

***

### 내가 예상한 답은 아래와 같았다.
```
//      2-4. 다음 중 변수를 잘못 초기화 한 것은?
        byte b = 256; // byte 타입은 -128 ~ 127까지 저장할 수 있다.
        char c = ''; // char의 값이 없다?.
        char answer = 'no'; // char은 한 문자만 가능하다. 여기서는 String을 써야함.
        float f = 3.14 // 맨 뒤에 ;가 없다. ;가 있더라도 뒤에F를 써줘야 함.
        double d = 1.4e3f; // 맨 뒤의 f가 없어도 된다?

//2-7. 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, '오류' 라고 적으세요.
        System.out.println("1" + "2");  // String 12
        System.out.println(true+""); // true
        System.out.println('A' + 'B'); // String AB
        System.out.println('1' + 2); // String 12
        System.out.println('1' + '2'); //String 12
        System.out.println('J' +"ava"); //String Java
        System.out.println(true + null); // 오류, boolean 타입은 true와 false만 가능?


        int x = 1;
        int y = 2;
        int z = 3;

        x = x + 1; // 위에서 미리 설정한 1이라는 값에 1을 더함
        y = y + 1; // 위에서 미리 설정한 2이라는 값에 1을 더함
        z = z - 2; // 위에서 미리 설정한 3이라는 값에 2를 뺌

        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println("z="+z);
        //예상 결과 : x=2, y=3, z=1
    }//main

}// Report1 class
```

***

### 해답 
처음엔 아스키코드를 생각 못하고 문자열로 풀었기에 다른 부분이 있었고 바꾼 답은 아래와 같았다.
```
//2-7. 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, '오류' 라고 적으세요.
        System.out.println("1" + "2");  // String 12
        System.out.println(true+""); // true
        System.out.println('A' + 'B'); // 아스키코드 - 131
        System.out.println('1' + 2); // 아스키코드 - 51
        System.out.println('1' + '2'); // 아스키코드 - 99
        System.out.println('J' +"ava"); //String Java
        System.out.println(true + null); // 오류, boolean 타입은 true와 false만 가능?
```



