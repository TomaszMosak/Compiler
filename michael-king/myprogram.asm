	.data
sinp:   .asciiz "INPUT> "
	.text
main:	li $s1,0
	li  $v0, 4
	la  $a0, sinp
	syscall
	li  $v0, 5
	syscall
	move  $s0,$v0
WLOOP0:
	move $t8,$s0
	addi $sp,$sp,-4
	sw $t8,0($sp)
	li $t9,0
	lw $t8,0($sp)
	addi $sp,$sp,4
	beq $t8,$t9,WEND0
	move $t8,$s1
	addi $sp,$sp,-4
	sw $t8,0($sp)
	move $t9,$s0
	lw $t8,0($sp)
	addi $sp,$sp,4
	add $s2,$t8,$t9
	move $s1,$s2
	li  $v0, 4
	la  $a0, sinp
	syscall
	li  $v0, 5
	syscall
	move  $s0,$v0
	j WLOOP0
WEND0:
	li  $v0, 1
	move $a0,$s1
	syscall
	li $v0, 10
	syscall
