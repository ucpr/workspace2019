#include <bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  vector<int> l;

  cin >> n;
  for (int i = 0; i < n * 2; i++) {
    int tmp; cin >> tmp;
    l.push_back(tmp);
  }

  int result = 0;
  sort(l.begin(), l.end());
  for (int i = 0; i < n; i++) {
    result += l[i*2];
  }

  cout << result << endl;
}
