
interface Kick_Strategy {
    public void kick();
}

interface Jump_Strategy {
    void jumping();
}

interface Roll_Strategy {
    void rolling();
}

class kick_weak implements Kick_Strategy {

    @Override
    public void kick() {
        System.out.println("kicked weak!");
    }
}

class kick_normal implements Kick_Strategy {

    @Override
    public void kick() {
        System.out.println("kicked normal!");
    }
}

class kick_hard implements Kick_Strategy {

    @Override
    public void kick() {
        System.out.println("kicked hard!");
    }
}

class jump_short implements Jump_Strategy {

    @Override
    public void jumping() {
        System.out.println("jump short!");
    }
}

class jump_high implements Jump_Strategy {

    @Override
    public void jumping() {
        System.out.println("jump high!");
    }
}

class CanRoll implements Roll_Strategy {

    @Override
    public void rolling() {
        System.out.println("can roll!");
    }
}

class CantRoll implements Roll_Strategy {

    @Override
    public void rolling() {
        System.out.println("can't roll!");
    }
}

class Default_action {
    public void Punch() {
        System.out.println("punched!");
    }

    public void Display() {
        System.out.println("displayed!");
    }
}

class Fighter {
    private Kick_Strategy kickStrategy;
    private Jump_Strategy jumpStrategy;
    private Roll_Strategy rollStrategy;
    private Default_action df;

    public Fighter(Kick_Strategy kickStrategy, Jump_Strategy jumpStrategy, Roll_Strategy rollStrategy) {
        this.kickStrategy = kickStrategy;
        this.jumpStrategy = jumpStrategy;
        this.rollStrategy = rollStrategy;
    }

    public void setAction() {
        kickStrategy.kick();
        jumpStrategy.jumping();
        rollStrategy.rolling();
        df.Punch();
        df.Display();
    }
}
