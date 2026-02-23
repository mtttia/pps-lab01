package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{
    private boolean pinInitialized = false;
    private boolean locked = false;
    private int pin = 0;

    @Override
    public void setPin(int pin) {
        pinInitialized = true;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(pin == this.pin){
            locked = false;
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
        return false;
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
