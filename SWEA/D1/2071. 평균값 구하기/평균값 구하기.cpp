#include<iostream>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
		double sum = 0;
        for(int i = 0; i < 10; ++i) {
            int num;
            cin >> num;
            sum += num;
        }
        sum = round(sum / 10);
        cout << "#" << test_case << " " << sum << endl;
	}
	return 0;
}