import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int positionX = 0, positionY = 0;

			char map[][] = new char[H][W];
			for (int h = 0; h < H; h++) {
				String str = sc.next();
				for (int w = 0; w < W; w++) {
					char c = str.charAt(w);
					map[h][w] = c;
					if (c == '<' || c == '>' || c == '^' || c == 'v') {
						positionX = w;
						positionY = h;
					}
				}
			}

			int count = sc.nextInt();
			String command = sc.next();
			for (int i = 0; i < count; i++) {
				char c = command.charAt(i);
				if (c == 'S') {
					if (map[positionY][positionX] == '<') {
						int range = positionX - 1;
						while (range >= 0) {
							if (map[positionY][range] == '#') {
								break;
							} else if (map[positionY][range] == '*') {
								map[positionY][range] = '.';
								break;
							}
							range--;
						}
					} else if (map[positionY][positionX] == '>') {
						int range = positionX + 1;
						while (range < W) {
							if (map[positionY][range] == '#') {
								break;
							} else if (map[positionY][range] == '*') {
								map[positionY][range] = '.';
								break;
							}
							range++;
						}
					} else if (map[positionY][positionX] == 'v') {
						int range = positionY + 1;
						while (range < H) {
							if (map[range][positionX] == '#') {
								break;
							} else if (map[range][positionX] == '*') {
								map[range][positionX] = '.';
								break;
							}
							range++;
						}
					} else if (map[positionY][positionX] == '^') {
						int range = positionY - 1;
						while (range >= 0) {
							if (map[range][positionX] == '#') {
								break;
							} else if (map[range][positionX] == '*') {
								map[range][positionX] = '.';
								break;
							}
							range--;
						}
					}
				}

				else if (c == 'L') {
					map[positionY][positionX] = '<';
					if (positionX - 1 >= 0 && map[positionY][positionX - 1] == '.') {
						map[positionY][positionX - 1] = '<';
						map[positionY][positionX] = '.';
						positionX -= 1;
					}

				} else if (c == 'R') {
					map[positionY][positionX] = '>';
					if (positionX + 1 < W && map[positionY][positionX + 1] == '.') {
						map[positionY][positionX + 1] = '>';
						map[positionY][positionX] = '.';
						positionX += 1;
					}
				} else if (c == 'U') {
					map[positionY][positionX] = '^';
					if (positionY - 1 >= 0 && map[positionY - 1][positionX] == '.') {
						map[positionY - 1][positionX] = '^';
						map[positionY][positionX] = '.';
						positionY -= 1;
					}

				} else if (c == 'D') {
					map[positionY][positionX] = 'v';
					if (positionY + 1 < H && map[positionY + 1][positionX] == '.') {
						map[positionY + 1][positionX] = 'v';
						map[positionY][positionX] = '.';
						positionY += 1;
					}
				}
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}