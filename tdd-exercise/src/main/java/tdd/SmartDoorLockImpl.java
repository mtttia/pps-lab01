package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    private final int maxAttempts;
    private boolean pinInitialized = false;
    private boolean locked = false;
    private boolean blocked = false;
    private int pin = 0;
    private int failedUnlockAttempts = 0;

    public SmartDoorLockImpl(int maxAttempts){
        this.maxAttempts = maxAttempts;
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

    }

    private boolean isPinInitialized(){
        return pinInitialized;
    }
}
