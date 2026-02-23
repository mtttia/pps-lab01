package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    private final int maxAttempts;
    private boolean pinInitialized;
    private boolean locked;
    private boolean blocked;
    private int pin;
    private int failedUnlockAttempts;

    public SmartDoorLockImpl(int maxAttempts){
        this.maxAttempts = maxAttempts;
        reset();
    }

    @Override
    public void setPin(int pin) {
        pinInitialized = true;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(blocked){
            return;
        }
        if(pin == this.pin) {
            locked = false;
            failedUnlockAttempts = 0;
            return;
        }
        if(++failedUnlockAttempts >= maxAttempts){
            blocked = true;
        }
    }

    @Override
    public void lock() {
        if(!isPinInitialized()){
            throw new IllegalStateException();
        }
        locked = true;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    @Override
    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return failedUnlockAttempts;
    }

    @Override
    public void reset() {
        pinInitialized = false;
        locked = false;
        blocked = false;
        pin = 0;
        failedUnlockAttempts = 0;
    }

    private boolean isPinInitialized(){
        return pinInitialized;
    }
}
