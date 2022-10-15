bool isMatch(string s, string p) {

    int n1=s.size();
    int n2=p.size();
    
    vector<vector<bool>> dp(n1+1,vector<bool> (n2+1,false));
    
    for(int i=0;i<=n1;++i){
        
        for(int j=0;j<=n2;++j){
            
            if(i==0 && j==0) dp[i][j]=true;
            else if (i==0 || j==0){
                
				 if(i==0 && p[j-1]=='*') dp[i][j]=dp[i][j-1];  
				 else                    dp[i][j]=false;  
				 
            }
           else if(p[j-1]=='*' || p[j-1]=='?' ){
		   
             if (p[j-1]=='?') dp[i][j]=dp[i-1][j-1];
             else             dp[i][j]=dp[i-1][j] + dp[i-1][j-1] + dp[i][j-1];
          
		  }
        else{
            if(s[i-1]==p[j-1]) dp[i][j]=dp[i-1][j-1];
            else               dp[i][j]=false;  
          }    
       }           
    }
    return dp[n1][n2];  
}
};