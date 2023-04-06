package com.yoojin.swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5607_조합_장유진 {
	private static final int MOD = 1234567891;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tcase;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long fac[] = new long[n+1];
			fac[0] = 1;
			
			for(int i=1;i<=n;i++) {
				fac[i] = (fac[i-1] * i) % MOD; // factorial 미리 구하기 
			}
			
			long bottom = (fac[r] * fac[n-r]) % MOD;
			long reBottom = fermat(bottom, MOD -2);
			
			System.out.println("#"+t+" " + ((fac[n]*reBottom)%MOD));
		}
		
	}
	
	private static long fermat(long n, int x) {
		if(x==0) return 1;
		long tmp = fermat(n,x/2);
		long ret = (tmp*tmp) % MOD;
		if(x%2==0) return ret;
		else return (ret*n) % MOD;
	}
}