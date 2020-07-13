package main;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
    

    

    
    public Gameplay() {
		addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
	}
	
	public void paint (Graphics g) {
		if(moves == 0) {
			initSnakeLength();
        }
		
		//draw frame		
		drawImageBorder(g);
		drawTitleImage(g);
		drawGameplayBorder(g);
		drawGameplayBackground(g);
		drawScoreAndLength(g);
		
		rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
        
        for(int a = 0; a<lengthofsnake; a++)
        {
            if(a==0 && right)
            {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0 && left)
            {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0 && down)
            {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0 && up)
            {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
        
            if(a!=0)
            {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
                
        }
        
        enemyimage=new ImageIcon("enemy.png");
        
        if((enemyxpos[xpos]== snakexlength[0] && enemyypos[ypos]==snakeylength[0]))
        {
        	lengthofsnake++;
        	score++;
        	xpos=random.nextInt(34);
        	ypos=random.nextInt(23);
        }
        
        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        for(int b=1;b<lengthofsnake;b++)
        {
        	if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0])
        	{
        		right=false;
        		left=false;
        		up=false;
        		down=false;
        		
        		g.setColor(Color.WHITE);
        		g.setFont(new Font("arial",Font.BOLD, 50));
        		g.drawString("GAME OVER", 300, 300);
        		
        		g.setFont(new Font("arial",Font.BOLD, 20));
        		g.drawString("Press Space to Restart", 350, 340);
        	}
        }
        
        g.dispose();
	}
	private void initSnakeLength() {	
            snakexlength[2] = 50; 
            snakexlength[1] = 75;
            snakexlength[0] = 100;
            
            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;           
	}
	private void drawScoreAndLength(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.PLAIN, 14));
		g.drawString("Scores: "+score, 780, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.PLAIN, 14));
		g.drawString("Length: "+lengthofsnake, 780, 50);
	}
	private void drawGameplayBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
	}
	private void drawGameplayBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
	}
	private void drawTitleImage(Graphics g) {
		titleImage= new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
	}
	private void drawImageBorder(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 51);
	}
	@Override
    public void keyTyped(KeyEvent ke) {
      
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    	if(e.getKeyCode()==KeyEvent.VK_SPACE)
    	{
    		moves=0;
    		score=0;
    		lengthofsnake=3;
    		repaint();
    	}
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    	{
    		moves++;
    		right=true;
    		if(!left)
    		{
    			right=true;
    		}
    		else
    		{
    			right=false;
    			left=true;
    		}
    		up=false;
    		down=false;
    	}
    	if(e.getKeyCode()==KeyEvent.VK_LEFT)
    	{
    		moves++;
    		left=true;
    		if(!right)
    		{
    			left=true;
    		}
    		else
    		{
    			left=false;
    			right=true;
    		}
    		up=false;
    		down=false;
    	}
    	if(e.getKeyCode()== KeyEvent.VK_UP)
    	{
    		moves++;
    		up=true;
    		if(!down)
    		{
    			up=true;
    		}
    		else
    		{
    			up=false;
    			down=true;
    		}
    		left=false;
    		right=false;
    	}
    	if(e.getKeyCode()== KeyEvent.VK_DOWN)
    	{
    		moves++;
    		down=true;
    		if(!up)
    		{
    			down=true;
    		}
    		else
    		{
    			down=false;
    			up=true;
    		}
    		left=false;
    		right=false;
    	}
    }


    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	timer.start();
    	if(right)
    	{
    		for(int r=lengthofsnake-1;r>=0;r--)
    		{
    			snakeylength[r+1]=snakeylength[r];
    		}
    		for(int r=lengthofsnake;r>=0;r--)
    		{
    			if(r==0)
    			{
    				snakexlength[r]=snakexlength[r]+25;
    			}
    			else
    			{
    				snakexlength[r]=snakexlength[r-1];
    			}
    			if(snakexlength[r]>850)
    			{
    				snakexlength[r]=25;
    			}
    		}
    		repaint();
    	}
    	if(left)
    	{
    		for(int r=lengthofsnake-1;r>=0;r--)
    		{
    			snakeylength[r+1]=snakeylength[r];
    		}
    		for(int r=lengthofsnake;r>=0;r--)
    		{
    			if(r==0)
    			{
    				snakexlength[r]=snakexlength[r]-25;
    			}
    			else
    			{
    				snakexlength[r]=snakexlength[r-1];
    			}
    			if(snakexlength[r]<25)
    			{
    				snakexlength[r]=850;
    			}
    		}
    		repaint();
    	}
    	if(up)
    	{
    		for(int r=lengthofsnake-1;r>=0;r--)
    		{
    			snakexlength[r+1]=snakexlength[r];
    		}
    		for(int r=lengthofsnake;r>=0;r--)
    		{
    			if(r==0)
    			{
    				snakeylength[r]=snakeylength[r]-25;
    			}
    			else
    			{
    				snakeylength[r]=snakeylength[r-1];
    			}
    			if(snakeylength[r]<75)
    			{
    				snakeylength[r]=625;
    			}
    		}
    		repaint();
    	}
    	if(down)
    	{
    		for(int r=lengthofsnake-1;r>=0;r--)
    		{
    			snakexlength[r+1]=snakexlength[r];
    		}
    		for(int r=lengthofsnake;r>=0;r--)
    		{
    			if(r==0)
    			{
    				snakeylength[r]=snakeylength[r]+25;
    			}
    			else
    			{
    				snakeylength[r]=snakeylength[r-1];
    			}
    			if(snakeylength[r]>625)
    			{
    				snakeylength[r]=75;
    			}
    		}
    		repaint();
    	}
    }
}



















