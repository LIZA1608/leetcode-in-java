#include<bits/stdc++.h>
#include<algorithm>
using namespace std;
void tower(int n,string src,string des,string help,int&count){
    if(n==0){
        return;
    }
    count++;
    tower(n-1,src,help,des,count);
    cout<<"Move "<<n<<"th"<<" disc from "<<src<<" to "<<des<<endl;
    tower(n-1,help,des,src,count);
}
int main()
{
	int n;
    cin>>n;
    int count=0;
tower(n,"T1","T2","T3",count);
cout<<count<<endl;
	return 0;
}
