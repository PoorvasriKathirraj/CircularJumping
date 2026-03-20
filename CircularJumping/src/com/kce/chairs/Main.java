package com.kce.chairs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[]args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int X=Integer.parseInt(br.readLine());
		int Y=Integer.parseInt(br.readLine());
		int[]A=new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=Integer.parseInt(br.readLine());
		}
		Queue<Integer>q=new LinkedList<>();
		boolean[]visited=new boolean[N+1];
		q.add(X);
		visited[X]=true;
		int steps=0;
		while(!q.isEmpty()) {
			int size=q.size();
			
			for(int i=0;i<size;i++) {
				int curr=q.poll();
				if(curr==Y) {
					System.out.println(steps);
					return ;
				}
				int jump=A[curr];
				int right=((curr+jump-1)%N)+1;
				int left=((curr-jump-1)%N+N)%N+1;
				
				if(!visited[right]) {
					visited[right]=true;
					q.add(right);
				}
				if(!visited[left]) {
					visited[left]=true;
					q.add(left);
				}
			}
			steps++;
		}
		System.out.println(-1);
		
	}

}
