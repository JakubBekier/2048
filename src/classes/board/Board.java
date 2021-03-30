package classes.board;

import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;

public class Board {
    public Integer[][] values = {{2,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

    public Board(){
    }

    public boolean Add2(){
        int empty = 0;

        outerloop:
        for (Integer[] row: values){
            for (Integer el: row) {
                if (el == 0){
                    empty++;
                    break outerloop;
                }
            }
        }

        if (empty == 0){
            return true;
        }
        boolean run = true;
        while (run){
            int x = new Random().nextInt(4);
            int y = new Random().nextInt(4);
            if (values[x][y] == 0){
                values[x][y] = 2;
                return false;
            }
        }
        return false;
    }

    public void move(String el){
        boolean modified = false;
        switch (el){
            case "W":
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 3; j++){
                        System.out.println(i);
                        if (values[i][j] == 0){
                            continue;
                        }

                        for (int a = j + 1; a < 4; a++){
                            if (values[i][j] == values[i][a]){
                                values[i][j] *= 2;
                                values[i][a] = 0;
                                break;
                            } else if(values[i][a] == 0){
                                continue;
                            } else {
                                break;
                            }
                        }

                        int k = 0;
                        while (k < j){
                            if (values[i][k] == 0){
                                values[i][k] = values[i][j];
                                values[i][j] = 0;
                                break;
                            }
                            k++;
                        }
                    }
                    int k = 0;
                    while (k < 4){
                        if (values[i][k] == 0){
                            values[i][k] = values[i][3];
                            values[i][3] = 0;
                            break;
                        }
                        k++;
                    }
                }
                break;

            case "S":
                for (int i = 0; i < 4; i++){
                    for (int j = 3; j > 0; j--){
                        if (values[i][j] == 0){
                            continue;
                        }

                        for (int a = j - 1; a >= 0; a--){
                            if (values[i][j] == values[i][a]){
                                values[i][j] *= 2;
                                values[i][a] = 0;
                                break;
                            } else if(values[i][a] == 0){
                                continue;
                            } else {
                                break;
                            }
                        }

                        int k = 3;
                        while (k > j){
                            if (values[i][k] == 0){
                                values[i][k] = values[i][j];
                                values[i][j] = 0;
                                break;
                            }
                            k--;
                        }
                    }
                    int k = 3;
                    while (k > 0){
                        if (values[i][k] == 0){
                            values[i][k] = values[i][0];
                            values[i][0] = 0;
                            break;
                        }
                        k--;
                    }
                }
                break;
            case "D":
                for (int i = 0; i < 4; i++){
                    for (int j = 3; j > 0; j--){
                        if (values[j][i] == 0){
                            continue;
                        }

                        for (int a = j - 1; a >= 0; a--){
                            if (values[j][i] == values[a][i]){
                                values[j][i] *= 2;
                                values[a][i] = 0;
                                break;
                            } else if(values[a][i] == 0){
                                continue;
                            } else {
                                break;
                            }
                        }

                        int k = 3;
                        while (k > j){
                            if (values[k][i] == 0){
                                values[k][i] = values[j][i];
                                values[j][i] = 0;
                                break;
                            }
                            k--;
                        }

                    }

                    int k = 3;
                    while (k > 0){
                        if (values[k][i] == 0){
                            values[k][i] = values[0][i];
                            values[0][i] = 0;
                            break;
                        }
                        k--;
                    }

                }
                break;

            case "A":
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 3; j++){
                        if (values[j][i] == 0){
                            continue;
                        }

                        for (int a = j + 1; a < 4; a++){
                            if (values[j][i] == values[a][i]){
                                values[j][i] *= 2;
                                values[a][i] = 0;
                                break;
                            } else if(values[a][i] == 0){
                                continue;
                            } else {
                                break;
                            }
                        }

                        int k = 0;
                        while (k < j){
                            if (values[k][i] == 0){
                                values[k][i] = values[j][i];
                                values[j][i] = 0;
                                break;
                            }
                            k++;
                        }
                    }
                    int k = 0;
                    while (k < 4){
                        if (values[k][i] == 0){
                            values[k][i] = values[3][i];
                            values[3][i] = 0;
                            break;
                        }
                        k++;
                    }
                }
                break;

        }
    }
}
