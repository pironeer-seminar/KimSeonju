package pironeer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {
    BufferedReader br;
    StringTokenizer st;   // 공백을 기준으로 문자열을 분리하는 객체

    public Reader() {     // 생성자
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {    // st가 null이거나 읽을 요소가 없으면 새롭게 한 줄을 입력받음 (br.readLine()).
            try {
                st = new StringTokenizer(br.readLine());  // 입력받은 문자열을 공백 단위로 나누어 StringTokenizer(st)에 저장.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();   // st.nextToken()을 호출하여 다음 단어(토큰)를 반환.
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();   // br.readLine()을 사용하여 한 줄을 통째로 읽음.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
