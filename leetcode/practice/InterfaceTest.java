package leetcode.practice;

public class InterfaceTest {
    public interface OnClickListener {
        void onClick(String whoIsClicking);
    }

    public static void main(String[] args) {
        // listen to on click
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(String whoIsClicking) {
                System.out.println("Owner: " + whoIsClicking);
            }
        };
        // writing in lambda style
        OnClickListener listener2 = (whoIsClicking) -> {
            System.out.println("Owner: " + whoIsClicking);
        };

        // simulate on click
        listener.onClick("Qi Ren");
        listener2.onClick("Qi Ren2");
    }
}
