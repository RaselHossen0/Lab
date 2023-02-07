#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    int a[n];
    int max=-INT_MAX;
    for(int i=0;i<n;i++){
        cin >> a[i];
        if(a[i]>max)
        max=a[i];
    }
    int cnt=0;
    while(max!=0){
     
        max/=10;   
        cnt++;
    }

    int p=pow(10,cnt);
cout<<p<<endl;
    cout<<cnt<<endl;
    vector<int > v[n];
    for(int i=0;i<n;i++)
    {
        v[a[i]/p].push_back(a[i]);
     
    }
    for(int i=0;i<n;i++){
       
            sort(v[i].begin(),v[i].end());
          
        
    }
    int index=0;
    int sortedA[n+1];
    for(int i=0;i<n;i++){
        for(int j=0;j<v[i].size();j++){
            sortedA[index]=v[i][j];
            index++;
        }
    }
    for(int i=0;i<index;i++){
        cout<<sortedA[i]<<" ";
    }

}