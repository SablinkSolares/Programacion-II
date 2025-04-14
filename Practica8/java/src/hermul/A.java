package hermul;

interface IncrementaZ {
    void incrementaZ();
}

class A implements IncrementaZ {
    public int x;
    public int z;
    
    public A(int x, int z) {
        this.x = x;
        this.z = z;
    }
    
    public void incrementaXZ() {
        x++;
        z++;
        System.out.println("A: incrementaXZ() -> x=" + x + ", z=" + z);
    }
    
    @Override
    public void incrementaZ() {
        z++;
        System.out.println("A: incrementaZ() -> z=" + z);
    }
}

class B implements IncrementaZ {
    public int y;
    public int z;
    
    public B(int y, int z) {
        this.y = y;
        this.z = z;
    }
    
    public void incrementaYZ() {
        y++;
        z++;
        System.out.println("B: incrementaYZ() -> y=" + y + ", z=" + z);
    }
    
    @Override
    public void incrementaZ() {  
        z++;
        System.out.println("B: incrementaZ() -> z=" + z);
    }
}

class D extends A {
    private B b;
    
    public D(int x, int y, int z) {
        super(x, z);
        this.b = new B(y, z);
        
        this.b.z = this.z;
    }
    
    public void incrementaXYZ() {
        x++;
        b.y++;
        z++;
        b.z = z; 
        System.out.println("D: incrementaXYZ() -> x=" + x + ", y=" + b.y + ", z=" + z);
    }
    
    public void incrementaYZ() {
        b.incrementaYZ();
        this.z = b.z; 
    }
    
    public int getY() {
        return b.y;
    }
    
    public int getBz() {
        return b.z;
    }
    
    @Override
    public void incrementaZ() {
        super.incrementaZ();
        b.z = this.z; 
    }
}



