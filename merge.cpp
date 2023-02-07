#include <bits/stdc++.h>
#define ll long long int
#define endl "\n"
using namespace std;
int N=1e9+7;
 void merge(int a[], int beg, int mid, int end)    
{    
    int i, j, k;  
    int n1 = mid - beg + 1;    
    int n2 = end - mid;    
      
    int LeftArray[n1], RightArray[n2]; 
    for (int i = 0; i < n1; i++)    
    LeftArray[i] = a[beg + i];    
    for (int j = 0; j < n2; j++)    
    RightArray[j] = a[mid + 1 + j];    
      
    i = 0; 
    j = 0; 
    k = beg; 
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i] <= RightArray[j])    
        {    
            a[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            a[k] = RightArray[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        a[k] = LeftArray[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        a[k] = RightArray[j];    
        j++;    
        k++;    
    }    
} 
void mergeSort(int a[], int beg, int end)  
{  
    if (beg < end)   
    {  
        int mid = (beg + end) / 2;  
        mergeSort(a, beg, mid);  
        mergeSort(a, mid + 1, end);  
        merge(a, beg, mid, end);  
    }  
} 
void print(int a[],int n){
    for(int i=0;i<n;i++){
    cout<<a[i]<<" ";
   }
    cout<<endl;
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
   mergeSort(a,0,n-1);
   print(a,n);


}   