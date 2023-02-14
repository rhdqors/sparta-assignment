# sparta Report04 과제

### 문제
```
5-2. 다음과 같은 배열이 있을 때, arr[3].length의 값은?
        int[][]arr ={
                {5,5,5,5,5},
                {10,10,10},
                {20,20,20,20},
                {30,30}
        }; // [30,30] 의 인덱스 개수인 2개

5-3. 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하세요. 예상 150
                int[] arr = {10, 20, 30, 40, 50};
                int sum = 0;
                
                for (int i=0; i< arr.length; i++) {
                    sum += arr[i];
                }
                System.out.println("sum="+sum);

5-4. 2차원 배열 arr에 담긴 모든 총합과 평균을 구하는 프로그램을 완성하세요.
        int[][] arr = {
                { 5, 5, 5, 5, 5 },
                { 10, 10, 10, 10, 10 },
                { 20, 20, 20, 20, 20 },
                { 30, 30, 30, 30, 30 }
        };
        int total = 0;
        float average = 0;
        for (int i=0; i<arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                total += arr[i][j];
                average = arr.length * arr[i].length;
            }
        }
        average = total / average;
        System.out.println("total=" + total);
        System.out.println("average=" + average);

5-5. 다음은 1과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
코드를 완성하세요. 다만 Math.random()을 사용했기 때문에 실행 결과 예시와 다를 수 있습니다.
                int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                int[] ball3 = new int[3];

                // 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다
                for (int i = 0; i < ballArr.length; i++) {
                    int j = (int) (Math.random() * ballArr.length);
                    int tmp = ballArr[0];

                    ballArr[0] = ballArr[j];
                    ballArr[j] = tmp;
                    System.out.println(Arrays.toString(ballArr));
                }
                ball3 = Arrays.copyOf(ballArr,3);
                // 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다
                for (int i = 0; i < ball3.length; i++) {
                    System.out.print(ball3[i]);
                }

5-6. 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다.
실행결과와 같이 동작하도록 빈 칸을 채우세요.

                String[] words = { "television", "computer", "mouse", "phone" };

                Scanner scanner = new Scanner(System.in);

                for (int i = 0; i < words.length; i++) {
                    char[] question = words[i].toCharArray(); // String을 char[]로 변환
                    int j = question.length;
                    String tmp = words[0];

                    words[0] = words[j];
                    words[j] = tmp;
                    System.out.println(Arrays.toString(words));
                    System.out.println(words[j]);
                    System.out.println((Arrays.toString(question))[0]);
                    String tmp = Arrays.toString(words);

                    System.out.printf("Q%d. %s의 정답을 입력하세요 .>", i + 1, new String(question));
                    String answer = scanner.nextLine();

                    // trim()으로 answer의 좌우 공백을 제거한 후, equals로 word[i]와 비교
                    if (words[i].equals(answer.trim()))
                        System.out.printf("맞았습니다.%n%n");
                    else
                        System.out.printf("틀렸습니다.%n%n");
                }
```
5-6번의 문제는 아직 해결하지 못했다.
5-5와 비슷하게 접근하여 words 배열의 인덱스 값들을 배열로 만들어둔 question까지는 완성했고,
이제 그 값들을 섞어주는 과정이 필요하다.