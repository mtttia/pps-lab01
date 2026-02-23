package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{
    public static final int FAILURE_UNLOCK_ATTEMPTS_BEFORE_BLOCKING = 2;

    private boolean pinInitialized = false;
    private boolean locked = false;
    private boolean blocked = false;
    private int pin = 0;
    private int failedUnlockAttempts = 0;

    @Override
    public void setPin(int pin) {
        pinInitialized = true;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(pin == this.pin) {
            locked = false;
            return;
        }
        if(++failedUnlockAttempts >= FAILURE_UNLOCK_ATTEMPTS_BEFORE_BLOCKING){
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
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }

    private boolean isPinInitialized(){
        return pinInitialized;
    }
}
