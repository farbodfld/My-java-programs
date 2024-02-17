public class Game {
    class Fighting {
        void Display() {
            System.out.println("Display");
        }

        void Punch() {
            System.out.println("Punch");
        }

        void Kick(KickStrategy kickStrategy) {
            kickStrategy.doKick();
        }

        void Jump(JumpStrategy jumpStrategy) {
            jumpStrategy.doJump();
        }

        void Roll(RollStrategy rollStrategy) {
            rollStrategy.doRoll();
        }
    }

    interface KickStrategy {
        void doKick();
    }

    class Kick1 implements KickStrategy {
        @Override
        public void doKick() {
            System.out.println("kick type 1");
        }
    }

    class Kick2 implements KickStrategy {
        @Override
        public void doKick() {
            System.out.println("kick type 2");
        }
    }

    class Kick3 implements KickStrategy {
        @Override
        public void doKick() {
            System.out.println("kick type 3");
        }
    }

    interface JumpStrategy {
        void doJump();
    }

    class LongJump implements JumpStrategy {
        @Override
        public void doJump() {
            System.out.println("long jump");
        }
    }

    class ShortJump implements JumpStrategy {
        @Override
        public void doJump() {
            System.out.println("short jump");
        }
    }

    interface RollStrategy {
        void doRoll();
    }

    class CanRoll implements RollStrategy {
        @Override
        public void doRoll() {
            System.out.println("can roll");
        }
    }

    class CantRoll implements RollStrategy {
        @Override
        public void doRoll() {
            System.out.println("can't roll");
        }
    }

    public class Fighter {
        Fighting fighting;
        KickStrategy kickStrategy;
        JumpStrategy jumpStrategy;
        RollStrategy rollStrategy;

        public Fighter(KickStrategy kickStrategy, JumpStrategy jumpStrategy, RollStrategy rollStrategy) {
            this.kickStrategy = kickStrategy;
            this.jumpStrategy = jumpStrategy;
            this.rollStrategy = rollStrategy;
        }

        void executeAction() {
            fighting.Display();
            fighting.Punch();
            fighting.Jump(jumpStrategy);
            fighting.Kick(kickStrategy);
            fighting.Roll(rollStrategy);
        }
    }
}
