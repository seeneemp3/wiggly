package practice;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class Main {
        private int id = 0;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public static void main(String[] args) {
                Main m = new Main();
                System.out.println(m.getId());
                m.setId(1);
                System.out.println(m.getId());
                m.setId(m.getId() + 1);
                System.out.println(m.getId());
        }
        }

