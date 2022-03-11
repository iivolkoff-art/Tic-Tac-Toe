package com.company;
import java.util.Scanner;


public class Map {
    private final int SizeArray = 3;
    private int X;
    private int Y;
    private int countEmpty = 9;
    private char a[][] = new char[SizeArray][SizeArray];
    private final char pointX = 'X';
    private final char pointO = 'O';
    private final char pointEmpty = '*';
    Scanner scan = new Scanner(System.in);


    public Map()
    {
        CreateMap();
    }


    public void CreateMap() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = pointEmpty;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void ReloadMap() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void SetPointX()
    {
        System.out.println("Введите X координату(X) ");
        X = scan.nextInt() - 1;
        System.out.println("Введите Y координату(X) ");
        Y = scan.nextInt() - 1;

        if(X > 3 || X < 0 || Y > 3 || Y < 0)
        {
            System.out.println('\n' + "Вы ввели неверно значение, попробуйте еще раз" + '\n');
            System.out.println();
            SetPointX();
        }

        if(a[Y][X] == pointEmpty) {
            a[Y][X] = pointX;
            countEmpty -= 1;
            ReloadMap();
            EndGame();
            ChekWin();
        }
        else{
            System.out.println('\n' + "Это поле уже занято! Попробуйте еще раз!" + '\n');
            SetPointX();
        }
    }


    public void SetPointO()
    {
        System.out.println("Введите X координату(O) ");
        X = scan.nextInt() - 1;
        System.out.println("Введите Y координату(0) ");
        Y = scan.nextInt() - 1;

        if(X > 3 || X < 0 || Y > 3 || Y < 0)
        {
            System.out.println('\n' + "Вы ввели неверно значение, попробуйте еще раз" + '\n');
            SetPointX();
        }

        if(a[Y][X] == pointEmpty) {
            a[Y][X] = pointO;
            countEmpty -= 1;
            ReloadMap();
            EndGame();
            ChekWin();
        }
        else{
            System.out.println('\n' + "Это поле уже занято! Попробуйте еще раз!" + '\n');
            SetPointO();
        }
    }


    public void Game()
    {
        SetPointX();
        SetPointO();
    }


    public void ChekWin()
    {
        int i = 0, j = 0;
        if (((a[i][j] == pointX) && (a[i][j + 1] == pointX) && (a[i][j + 2] == pointX))
                || ((a[i][j] == pointX) && (a[i + 1][j] == pointX) && (a[i + 2][j] == pointX))
                || ((a[i][j] == pointX) && (a[i + 1][j + 1] == pointX) && (a[i + 2][j + 2] == pointX))
                || ((a[i + 2][j] == pointX) && (a[i + 1][j + 1] == pointX) && (a[i][j + 2] == pointX))
                || ((a[i + 1][j] == pointX) && (a[i + 1][j + 1] == pointX) && (a[i + 1][j + 2] == pointX))
                || ((a[i + 2][j] == pointX) && (a[i + 2][j + 1] == pointX) && (a[i + 2][j + 2] == pointX))
                || ((a[i][j + 1] == pointX) && (a[i + 1][j + 1] == pointX) && (a[i + 2][j + 1] == pointX))
                || ((a[i][j + 2] == pointX) && (a[i + 1][j + 2] == pointX) && (a[i + 2][j + 2] == pointX)))
        {
            System.out.println('\n' + "WIN X");
            System.exit(0);
        }
        else if (((a[i][j] == pointO) && (a[i][j + 1] == pointO) && (a[i][j + 2] == pointO))
                || ((a[i][j] == pointO) && (a[i + 1][j] == pointO) && (a[i + 2][j] == pointO))
                || ((a[i][j] == pointO) && (a[i + 1][j + 1] == pointO) && (a[i + 2][j + 2] == pointO))
                || ((a[i + 2][j] == pointO) && (a[i + 1][j + 1] == pointO) && (a[i][j + 2] == pointO))
                || ((a[i + 1][j] == pointO) && (a[i + 1][j + 1] == pointO) && (a[i + 1][j + 2] == pointO))
                || ((a[i + 2][j] == pointO) && (a[i + 2][j + 1] == pointO) && (a[i + 2][j + 2] == pointO))
                || ((a[i][j + 1] == pointO) && (a[i + 1][j + 1] == pointO) && (a[i + 2][j + 1] == pointO))
                || ((a[i][j + 2] == pointO) && (a[i + 1][j + 2] == pointO) && (a[i + 2][j + 2] == pointO)))
        {
            System.out.println('\n' + "WIN 0");
            System.exit(0);
        }
    }


    public void EndGame()
    {
        if(countEmpty == 0)
        {
            System.out.println('\n' + "Конец Игры!");
            System.exit(0);
        }
    }
 }

