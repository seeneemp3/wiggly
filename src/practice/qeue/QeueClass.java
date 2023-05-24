package practice.qeue;

public class QeueClass {

    class CircularQ implements QeueInterface{
        private char q[];
        private int putloc,getloc;

        public CircularQ (int size){
            q=new char[size];
            putloc=getloc=0;
        }

        @Override
        public void put(char ch) {
            if((putloc==getloc-1)||(putloc==q.length-1)&&(getloc==0)){
                System.out.println("queue is full");
                return;
            }

            q[putloc++]=ch;

            if (putloc==q.length) putloc=0;
        }

        @Override
        public char get() {
            if (putloc==getloc){
                System.out.println("queue is empty");
                return (char) 0;
            }
            char ch=q[getloc++];

            if (getloc==q.length) getloc=0;

            return q[getloc];
        }
    }
    class FixedQ implements QeueInterface{
        private char q[];
        private int putloc,getloc;

        public FixedQ (int size){
            q=new char[size];
            putloc=getloc=0;
        }

        @Override
        public void put(char ch) {
            if(putloc==q.length)
            {
                System.out.println("queue is full");
                return;
            }
            q[putloc++]=ch;
        }

        @Override
        public char get() {
            if(getloc==0)
            {
                System.out.println("queue is empty");
                return 0;
            }
            return q[getloc++];
        }
    }
}
