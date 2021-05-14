// Template For Java Codeforce 
import java.io.*;
import java.util.*;

public class Solve {
    public static FastReader in = new FastReader();
    static Comparator<int[]> comp = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < b[i]) return -1;
                else if (a[i] > b[i]) return 1;
            }
            return 0;
        }
    };

    // Comparators for array
    static Comparator<int[]> sortByFirst = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
        }
    };
    static Comparator<int[]> sortBySecond = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    };

    // Main
    public static void main(String[] args) throws IOException {

    }



    // Fast Reader
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private int MAX_LINE_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer, lineBuf;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            lineBuf = new byte[MAX_LINE_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public boolean hasNext() throws IOException {
            byte c;
            while ((c = read()) != -1) {
                if (c > ' ') {        // Find first byte bigger than ' '
                    bufferPointer--;
                    return true;
                }
            }
            return false;
        }

        // return the next line that contains at least one character > ' '
        public String nextLine() throws IOException {
            int ctr = 0;
            byte c;
            boolean empty = true;
            while ((c = read()) != -1) {
                if (c == '\r') continue;    // ignore '\r'
                if (c == '\n') {
                    if (empty) {
                        ctr = 0;
                        continue;
                    } // read only spaces etc. until \n
                    else break;
                }
                if (ctr == MAX_LINE_SIZE) {
                    MAX_LINE_SIZE *= 2;
                    lineBuf = Arrays.copyOf(lineBuf, MAX_LINE_SIZE);
                }
                lineBuf[ctr++] = c;
                if (c > ' ') empty = false;
            }
            return new String(lineBuf, 0, ctr);
        }

        public String next() throws IOException {
            int ctr = 0;
            byte c = read();
            while (c <= ' ') c = read();
            while (c > ' ') {
                if (ctr == MAX_LINE_SIZE) {
                    MAX_LINE_SIZE *= 2;
                    lineBuf = Arrays.copyOf(lineBuf, MAX_LINE_SIZE);
                }
                lineBuf[ctr++] = c;
                c = read();
            }
            return new String(lineBuf, 0, ctr);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            if (bytesRead <= 0) return -1;  // No data
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    // Other Helper Methods / Debug
    public static int[] createArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}










