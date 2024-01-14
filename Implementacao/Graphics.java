package Implementacao;

class Graphics {
    private static final String CLEAR_SCREEN = "\u001b[2J";
    private static final String GOTO_COORD = "\u001b[%d;%dH";
    private static final String SHOW_CURSOR = "\u001b[?25h";
    private static final String HIDE_CURSOR = "\u001b[?25l";
  
    public static void cls() {
      System.out.println(CLEAR_SCREEN);
    }
  
    public static void gotoXY(int x, int y) {
      System.out.print(String.format(GOTO_COORD, x, y));
    }
  
    public static void showCursor() {
      System.out.print(SHOW_CURSOR);
    }
  
    public static void hideCursor() {
      System.out.print(HIDE_CURSOR);
    }
  }
