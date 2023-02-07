#include <bits/stdc++.h>
#define ll long long int
#define endl "\n"
using namespace std;
int N=1e9+7;
int partition (int a[],int d[], int start, int end)  
{  
    int pivot = d[end]; 
    int i = (start - 1);  
  
    for (int j = start; j <= end - 1; j++)  
    {  
     
        if (d[j] < pivot)  
        {  
            i++; 
            int t = d[i];  
            d[i] = d[j];  
            d[j] = t;  
             int t1 = a[i];  
            a[i] = a[j];  
            a[j] = t1; 
        }  
       
    }  
    // cout<<" **"<<a[i]<<endl;
    int t = d[i+1];  
    d[i+1] = d[end];  
    d[end] = t;
     int t1 = a[i+1];  
    a[i+1] = a[end];  
    a[end] = t1;  
    return (i + 1);  
}  
  
 void print(int a[],int n){
    for(int i=0;i<n;i++){
    cout<<a[i]<<" ";
   }
    cout<<endl;
   

 }
void quick(int a[],int d[], int start, int end) 
{  
    if (start < end)  
    {  
        int p = partition(a,d, start, end);  
       // print(a,end+1);
        //cout<<a[p]<<" * ";
        quick(a,d, start, p - 1);  
        quick(a, d,p + 1, end);  
       
    }  
} 
void radixSort(int a[],int start,int end){
    int n=end-start+1;
    int d[n];
    int max=-INT_MAX;
    for(int i=0;i<n;i++){
        if(a[i]>max)
        max=a[i];
    }
    for(int place=1;max/place;place*=10){
        for(int i=0;i<n;i++){
            d[i]=(a[i]/place)%10;
        }
        quick(a,d,start,end);
        
     }

    }
int main()
{
   ios_base::sync_with_stdio(0);
   cin.tie(nullptr); cout.tie(nullptr);
  
    int n;
    cin >> n;
    int a[n+1];
    for(int i=0;i<n;i++){
        cin >> a[i];
    }
    radixSort(a,0,n-1);
    print(a,n);
    cout<<endl;
   

}