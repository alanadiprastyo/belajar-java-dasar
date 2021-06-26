public class AplikasiTodolist {

    //membuat string array untuk menampung data
    public static String[] model = new String[10];

    //membuat objek input scanner
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        //testShowTodoList();
        //testAddTodoList();
        //testRemoveTodoList();
        //testInput();
        //testViewShowTodoList();
        //testViewAddTodoList();
        //testViewRemoveTodoList();
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){

        System.out.println("TODOLIST");
        for ( var i =0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }

    }

    /**
     * Fungsi test untuk show todo list
     */
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar : aplikasi todolist";
        model[2] = "Buku Clean Code";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo){

        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++){
            if(model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran arary 2x lipat
        if(isFull){
            var temporary = model;
            model = new String[model.length * 2];
            for(int i = 0; i < temporary.length; i++){
                model[i] = temporary[i];
            }
        }

        //tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * test add todo list
     */
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++){
            addTodoList("Contoh Todo ke . " + i);
        }
        showTodoList();
    }

    /**
     * menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number){

        //hapus index dimulai dari 0 (sehingga number - 1), karena no dimulai dari 1 sedangkan index dimulai dari 0
        if( (number - 1) >= model.length){
            return false;
        }else if(model[number - 1] == null){
            return false;
        } else {
            for (int i = (number-1); i < model.length; i++){
                if(i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Test untuk remove todo list
     */
    public static void testRemoveTodoList(){

        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * membuat method input data dengan tipe string
     * @return
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * menampilkan view todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")) {
            break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }


    /**
     * menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList(){

        System.out.println("MENAMBAH TODOLIST");
        var todo = input("Todo (x jika batal)");

        if(todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    /**
     * test untuk view todo list
     */
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();

        showTodoList();
    }

    /**
     * menampilkan remove dari todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")){
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    /**
     * test untuk hapus todo list
     */
    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }

}
